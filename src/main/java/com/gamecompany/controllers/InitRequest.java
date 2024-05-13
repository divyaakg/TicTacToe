package com.gamecompany.controllers;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gamecompany.models.Player;
import lombok.Data;

import java.util.List;

//@JsonSerialize
@Data
public class InitRequest {
    private List<PlayerRequest> players;
}
