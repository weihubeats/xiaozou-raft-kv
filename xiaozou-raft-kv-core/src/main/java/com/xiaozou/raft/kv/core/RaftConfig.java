package com.xiaozou.raft.kv.core;

/**
 * @author : wh
 * @date : 2025/3/30 23:26
 * @description:
 */
public class RaftConfig {

    /**
     * 如果没有收到任何信息，追随者就会成为候选者
     * 以毫秒为单位的选举超时时间
     */
    private int electionTimeoutMilliseconds = 5000;
    
    /**
     * master 给 slave发送心跳的心跳周期
     */
    private int heartbeatPeriodMilliseconds = 500;
    
    /**
     * 快照定时器执行间隔
     */
    private int snapshotPeriodSeconds = 3600;

    /**
     * 日志条目大小达到snapshotMinLogSize，才做快照
     */
    private int snapshotMinLogSize = 100 * 1024 * 1024;
    
    /**
     * 每个请求的最大快照字节数
     */
    private int maxLogEntriesPerRequest = 5000;
    
    /**
     * 单个段文件大小，默认100m
     */
    private int maxSegmentFileSize = 100 * 1000 * 1000;
    
    /**
     * follower与leader之间的差距在catchupMargin之内，才能参与选举和提供服务
     */
    private long catchupMargin = 500;
    
    /**
     * 复制最大等待超时时间，单位ms
     */
    private long maxAwaitTimeout = 1000;
    
    /**
     * 与其他节点进行同步、选主等操作的线程池大小
     */
    private int raftConsensusThreadNum = 20;
    
    /**
     * 是否异步写数据；true表示主节点保存后就返回，然后异步同步给从节点；
     * false表示主节点同步给大多数从节点后才返回。
     */
    private boolean asyncWrite = false;
    
    /**
     * raft的log和snapshot父目录，绝对路径
     */
    private String dataDir = System.getProperty("com.xiaozou.raft.data.dir");
}
