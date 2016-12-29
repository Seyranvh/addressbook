package com.svh.addressbook.remoteregistry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by SVh on 29/12/2016.
 */
public class CatalogueClient {
    private String host;
    private int port;
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public CatalogueClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect() {
        try {
            socket = new Socket(this.host, this.port);
            writer = new PrintWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            System.out.println("Obs: Host: " + this.host + " is not reachable");
        }
    }

    public void sendRequest(String request) {
        writer.println(request);
        writer.flush();
    }

    public String waitForResponse() {
        try {
            String record = "";
            StringBuilder stringBuilder = new StringBuilder();
            //Reading Server contacts
            while ((record = reader.readLine()) != null && !record.equals("")) {
                stringBuilder.append(record + "\n");
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }

    public void disconnect() {
        sendRequest("exit");
        writer.flush();
        writer.close();
        try {
            reader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
