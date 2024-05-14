package com.gamecompany.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowResponse {
    char [][]matrix;
    boolean didIwin;

}
