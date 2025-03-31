package com.xiaozou.raft.kv.core.service;

import com.xiaozou.raft.core.proto.RaftProto;

/**
 * @author : wh
 * @date : 2025/3/31 21:19
 * @description: raft集群管理接口 后续可以考虑优化为grpc
 */
public interface RaftClientService {

    /**
     * 获取raft集群leader节点信息
     * @param request
     * @return
     */
    com.xiaozou.raft.core.proto.RaftProto.GetLeaderResponse getLeader(RaftProto.GetLeaderRequest request);

}
