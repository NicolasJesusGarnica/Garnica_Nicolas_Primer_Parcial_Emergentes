package com.uatf.api_equipos.dto;

import lombok.Data;

@Data
public class EquipoDTO {
    private Long id;
    private String nombre;
    private String deporte;
    private String ciudad;
    private Integer fundacion;
}