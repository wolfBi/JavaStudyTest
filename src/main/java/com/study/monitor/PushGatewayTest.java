package com.study.monitor;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import io.prometheus.client.exporter.PushGateway;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PushGatewayTest {
    public static void main(String[] args) {
        try {
            PushGateway pushGateway = new PushGateway("localhost:9091");
            CollectorRegistry registry = new CollectorRegistry();
            Gauge gauge = Gauge.build("ITTJobMonitor","Ittjob Monitor")
                    .labelNames("Team","Action","EmailID").create();
            for (int i = 0; i < 5; i++) {
                gauge.labels("Test Team","Send",""+i).set(3000+i*50);
            }
            gauge.register(registry);

            Gauge createdGauge = Gauge.build("ITTJob","Ittjob")
                    .labelNames("Team","Action","EmailID").create();
            for (int i = 0; i < 5; i++) {
                createdGauge.labels("Test Team","Created",""+i).set(3600+i*50);
            }
            createdGauge.register(registry);

            Map<String,String> groupkey = new HashMap<>();
            groupkey.put("instance","ITTJobMonitor");
            pushGateway.pushAdd(registry,"optimize",groupkey);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
