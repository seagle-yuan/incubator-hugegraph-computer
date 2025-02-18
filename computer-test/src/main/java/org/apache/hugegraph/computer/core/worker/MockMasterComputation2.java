/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.apache.hugegraph.computer.core.worker;

import org.apache.hugegraph.computer.core.graph.value.DoubleValue;
import org.apache.hugegraph.computer.core.graph.value.FloatValue;
import org.apache.hugegraph.computer.core.graph.value.IntValue;
import org.apache.hugegraph.computer.core.graph.value.LongValue;
import org.apache.hugegraph.computer.core.master.MasterComputationContext;
import org.apache.hugegraph.testutil.Assert;

public class MockMasterComputation2 extends MockMasterComputation {

    @Override
    protected void assertStep0Aggregators(MasterComputationContext context) {
        Assert.assertEquals(new IntValue(10), context.aggregatedValue(
                AGGR_CUSTOM_INT));
        Assert.assertEquals(new FloatValue(10.4f), context.aggregatedValue(
                AGGR_CUSTOM_FLOAT));

        Assert.assertEquals(new FloatValue(6.28f), context.aggregatedValue(
                AGGR_FLOAT_UNSTABLE));
        Assert.assertEquals(new IntValue(10), context.aggregatedValue(
                AGGR_INT_UNSTABLE));

        Assert.assertEquals(new IntValue(10), context.aggregatedValue(
                AGGR_INT_SUM));
        Assert.assertEquals(new IntValue(8), context.aggregatedValue(
                AGGR_INT_MAX));

        Assert.assertEquals(new LongValue(10L), context.aggregatedValue(
                AGGR_LONG_SUM));
        Assert.assertEquals(new LongValue(8L), context.aggregatedValue(
                AGGR_LONG_MAX));

        Assert.assertEquals(new FloatValue(20.8f), context.aggregatedValue(
                AGGR_FLOAT_SUM));
        Assert.assertEquals(new FloatValue(-10.0f), context.aggregatedValue(
                AGGR_FLOAT_MIN));

        Assert.assertEquals(new DoubleValue(20.8), context.aggregatedValue(
                AGGR_DOUBLE_SUM));
        Assert.assertEquals(new DoubleValue(-10.0), context.aggregatedValue(
                AGGR_DOUBLE_MIN));
    }

    @Override
    protected void assertStep1Aggregators(MasterComputationContext context) {
        Assert.assertEquals(new IntValue(10), context.aggregatedValue(
                AGGR_CUSTOM_INT));
        Assert.assertEquals(new FloatValue(10.4f), context.aggregatedValue(
                AGGR_CUSTOM_FLOAT));

        Assert.assertEquals(new FloatValue(6.28f), context.aggregatedValue(
                AGGR_FLOAT_UNSTABLE));
        Assert.assertEquals(new IntValue(9), context.aggregatedValue(
                AGGR_INT_UNSTABLE));

        Assert.assertEquals(new IntValue(10), context.aggregatedValue(
                AGGR_INT_SUM));
        Assert.assertEquals(new IntValue(8), context.aggregatedValue(
                AGGR_INT_MAX));

        Assert.assertEquals(new LongValue(10L), context.aggregatedValue(
                AGGR_LONG_SUM));
        Assert.assertEquals(new LongValue(8L), context.aggregatedValue(
                AGGR_LONG_MAX));

        Assert.assertEquals(new FloatValue(20.8f), context.aggregatedValue(
                AGGR_FLOAT_SUM));
        Assert.assertEquals(new FloatValue(-10.0f), context.aggregatedValue(
                AGGR_FLOAT_MIN));

        Assert.assertEquals(new DoubleValue(20.8), context.aggregatedValue(
                AGGR_DOUBLE_SUM));
        Assert.assertEquals(new DoubleValue(-10.0), context.aggregatedValue(
                AGGR_DOUBLE_MIN));
    }
}
