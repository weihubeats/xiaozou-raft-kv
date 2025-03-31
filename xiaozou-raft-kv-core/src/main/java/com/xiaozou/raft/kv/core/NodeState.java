package com.xiaozou.raft.kv.core;

/**
 * @author : wh
 * @date : 2025/3/30 23:22
 * @description:
 */
public enum NodeState {

    STATE_FOLLOWER,
    STATE_PRE_CANDIDATE,
    STATE_CANDIDATE,
    STATE_LEADER
}
