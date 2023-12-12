package br.inatel.labs.labmqtt.client;


import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.UUID;

public class SensorTemperaturaSubscriber {

    public static void main(String[] args) {
        final String subscriberId = UUID.randomUUID().toString();

        IMqttClient subscriber = null;
        try {
            subscriber = new MqttClient(MyConstants.URI_BROKER, subscriberId);

            final MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);
            options.setConnectionTimeout(10);
            subscriber.connect(options);
            System.out.println("Subscriber conectado e aguardando mensagem...");

            subscriber.subscribe(MyConstants.TOPIC_SENSOR, (topic, message) -> {
                final byte[] payload = message.getPayload();
                System.out.println("Mensagem recebida: " + message);
                System.out.println("Topico recebido: " + topic);
            });
        } catch (MqttException e) {
            e.printStackTrace();
        } finally {
            try {
                subscriber.close();
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
    }
}
