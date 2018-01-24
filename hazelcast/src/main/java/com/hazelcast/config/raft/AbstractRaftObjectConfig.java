/*
 *  Copyright (c) 2008-2018, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.config.raft;

/**
 * TODO: Javadoc Pending...
 *
 */
public abstract class AbstractRaftObjectConfig {

    private String name;

    private String raftGroupRef;

    private RaftGroupConfig raftGroupConfig;

    public AbstractRaftObjectConfig() {
    }

    public AbstractRaftObjectConfig(String name, String raftGroupRef) {
        this.name = name;
        this.raftGroupRef = raftGroupRef;
    }

    public AbstractRaftObjectConfig(String name, RaftGroupConfig raftGroupConfig) {
        this.name = name;
        this.raftGroupConfig = raftGroupConfig;
    }

    public String getName() {
        return name;
    }

    public AbstractRaftObjectConfig setName(String name) {
        this.name = name;
        return this;
    }

    public String getRaftGroupRef() {
        return raftGroupRef;
    }

    public AbstractRaftObjectConfig setRaftGroupRef(String raftGroupRef) {
        if (raftGroupConfig != null) {
            throw new IllegalArgumentException("Only one of 'raftGroupRef' or 'raftGroupConfig' can be defined!");
        }
        this.raftGroupRef = raftGroupRef;
        return this;
    }

    public RaftGroupConfig getRaftGroupConfig() {
        return raftGroupConfig;
    }

    public AbstractRaftObjectConfig setRaftGroupConfig(RaftGroupConfig raftGroupConfig) {
        if (raftGroupRef != null) {
            throw new IllegalArgumentException("Only one of 'raftGroupRef' or 'raftGroupConfig' can be defined!");
        }
        this.raftGroupConfig = raftGroupConfig;
        return this;
    }
}
