package com.example.pagination.dto;

import java.time.LocalDateTime;

public record CustomerNotFoundError(LocalDateTime timestamp, Integer status , String message) {

}
