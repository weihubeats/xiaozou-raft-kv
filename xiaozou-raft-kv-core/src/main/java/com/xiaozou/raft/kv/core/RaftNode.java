package com.xiaozou.raft.kv.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : wh
 * @date : 2025/3/30 23:22
 * @description:
 */
@Slf4j
public class RaftNode {
    
    private RaftConfig raftConfig;

    private NodeState state = NodeState.STATE_FOLLOWER;

    /**
     * 任期号
     */
    private long currentTerm;

    /**
     * 在当前获得选票的候选人的 Id
     */
    private int votedFor;

    /**
     * leader id
     */
    private int leaderId;

    /**
     * 已知的最大的已经被提交的日志条目的索引值
     */
    private long commitIndex;
    
    /**
     * 最后被应用到状态机的日志条目索引值
     */
    private volatile long lastAppliedIndex;

    private Lock lock = new ReentrantLock();

    private Condition commitIndexCondition = lock.newCondition();
    
    private Condition catchUpCondition = lock.newCondition();

    private ExecutorService executorService;
    
    private ScheduledExecutorService scheduledExecutorService;
    
    private ScheduledFuture electionScheduledFuture;
    
    private ScheduledFuture heartbeatScheduledFuture;

    public RaftNode(RaftConfig raftConfig) {
        this.raftConfig = raftConfig;
    }
}
