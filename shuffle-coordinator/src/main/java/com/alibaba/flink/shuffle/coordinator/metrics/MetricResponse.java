/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.flink.shuffle.coordinator.metrics;

import com.alibaba.flink.shuffle.common.utils.CommonUtils;
import com.alibaba.flink.shuffle.rest.RestResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.metrics.common.MetricObject;

import java.util.List;
import java.util.Map;

/** Response of the metric rest request. */
public class MetricResponse implements RestResponse {

    private final Map<String, List<MetricObject>> metricsData;

    public MetricResponse(Map<String, List<MetricObject>> metricsData) {
        CommonUtils.checkArgument(metricsData != null, "Must be not null.");
        this.metricsData = metricsData;
    }

    @Override
    public String toJson() throws Exception {
        return JSON.toJSONString(metricsData);
    }
}
