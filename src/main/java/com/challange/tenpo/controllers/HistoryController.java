package com.challange.tenpo.controllers;

import com.challange.tenpo.entitys.History;
import com.challange.tenpo.services.HistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Api(tags = "History")
public class HistoryController {

    private final HistoryService historyService;

    @GetMapping(value = "/history")
    @ApiOperation(value = "Get History")
    public ResponseEntity<List<History>> getHistoryHistory(
            @RequestHeader(required = true, value = "Authorization") String auth,
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ResponseEntity.ok(historyService.getHistory(pageNumber, pageSize, sortBy));
    }

}

