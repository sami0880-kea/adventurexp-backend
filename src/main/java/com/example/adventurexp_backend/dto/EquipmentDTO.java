package com.example.adventurexp_backend.dto;

public record EquipmentDTO(int id, String name, int availableAmount, int bookedAmount, int price, int activityId) {
}
