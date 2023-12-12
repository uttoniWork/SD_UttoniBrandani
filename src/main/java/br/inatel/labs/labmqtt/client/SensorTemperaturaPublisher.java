package br.inatel.labs.labmqtt.client;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.Random;
import java.util.UUID;

public class SensorTemperaturaPublisher {

    public static void main(String[] args) {
        IMqttClient publisher = null;

        try {
            final String publisherId = UUID.randomUUID().toString();
            publisher = new MqttClient(MyConstants.URI_BROKER, publisherId);

            final MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);
            options.setConnectionTimeout(10);
            publisher.connect(options);

            for (int i = 0; i < 10; i++) {
                final MqttMessage msg = getTemperatureMessage();
                msg.setQos(0);
                msg.setRetained(true);

                publisher.publish(MyConstants.TOPIC_SENSOR, msg);

                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                publisher.disconnect();
                publisher.close();
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
    }

    private static MqttMessage getTemperatureMessage() {
        final Random r = new Random();
        final double temperatura = 80 + r.nextDouble() * 20.0;
        final byte[] payload = String.format("T:%04.2f", temperatura).getBytes();

        return new MqttMessage(payload);
    }
}
