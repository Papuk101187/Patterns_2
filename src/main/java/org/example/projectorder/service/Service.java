package org.example.projectorder.service;

import org.example.projectorder.details.Order;

import java.io.IOException;

public interface Service {


    String action(Order order) throws IOException, InterruptedException;



}
