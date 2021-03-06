// Copyright 2016 Twitter. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.apache.storm;

import java.util.Map;

import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.generated.NotAliveException;
import org.apache.storm.generated.StormTopology;

// import org.apache.storm.generated.ClusterSummary;
// import org.apache.storm.generated.KillOptions;
// import org.apache.storm.generated.SubmitOptions;
// import org.apache.storm.generated.RebalanceOptions;
// import org.apache.storm.generated.TopologyInfo;


public interface ILocalCluster {
  @SuppressWarnings("rawtypes")
  void submitTopology(String topologyName, Map conf, StormTopology topology) throws
      AlreadyAliveException, InvalidTopologyException;

  // void submitTopologyWithOpts(
  //  String topologyName, Map conf, StormTopology topology, SubmitOptions submitOpts) throws
  // AlreadyAliveException, InvalidTopologyException;
  void killTopology(String topologyName) throws NotAliveException;

  // void killTopologyWithOpts(String name, KillOptions options) throws NotAliveException;
  void activate(String topologyName) throws NotAliveException;

  void deactivate(String topologyName) throws NotAliveException;

  // void rebalance(String name, RebalanceOptions options) throws NotAliveException;
  void shutdown();

  String getTopologyConf(String id);

  StormTopology getTopology(String id);

  // ClusterSummary getClusterInfo();
  // TopologyInfo getTopologyInfo(String id);
  @SuppressWarnings("rawtypes")
  Map getState();
}
