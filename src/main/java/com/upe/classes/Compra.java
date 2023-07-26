package com.upe.classes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Compra {
    private int vendedor_id;
    private int cliente_id;
    private String status;
    private float total;

    public Compra(int vendedor_id, int cliente_id) {
        this.vendedor_id = vendedor_id;
        this.cliente_id = cliente_id;
        this.status = "ABERTA";
        this.total = 0.0f;
    }

    public int getVendedor_id() {
        return vendedor_id;
    }

    public void setVendedor_id(int vendedor_id) {
        this.vendedor_id = vendedor_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
