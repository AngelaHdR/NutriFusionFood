package com.fpmislata.NutriFusionFood.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ToolTest {
    Tool tool;

    @Test
    void createAllParameters() {
        tool = new Tool(1, "sarten", "pan");
    }

    @Test
    void checkId() {
        tool = new Tool(1, "sarten", "pan");
        assertEquals(1, tool.getId());
    }

    @Test
    void checkNameEs() {
        tool = new Tool(1, "sarten", "pan");
        assertEquals("sarten", tool.getName_es());
    }

    @Test
    void checkNameEn() {
        tool = new Tool(1, "sarten", "pan");
        assertEquals("pan", tool.getName_en());
    }
}
