package com.xyi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Tests {
    @Test
    public void decode() {
        assertEquals("", PackRLE.decode("6321"));
        assertEquals("LLLLLLOOOOTTTLLLLGGGGGGGNNN", PackRLE.decode("6L4O3T4L7G3N"));
        assertEquals("ZZZZZZXXXYYYYYYYYYYYY", PackRLE.decode("6Z3X12Y"));
        assertEquals("JJKJASMASMMkasaassssMNNNNMMMMalkslkkkkkkQPOWPQQQQQ",
                PackRLE.decode("2JKJASMAS2Mkas2a4sM4N4Malksl6kQPOWP5Q"));
        assertEquals("ppppppllllmmznnnoorrrlllllllll",
                PackRLE.decode("6p4l2mz3n2o3r9l"));

    }

    @Test
    public void encode() {
        assertEquals("5b7O4z10M3P", PackRLE.encode("bbbbbOOOOOOOzzzzMMMMMMMMMMPPP"));
        assertEquals("12A", PackRLE.encode("AAAAAAAAAAAA"));
        assertEquals("7bn6S", PackRLE.encode("bbbbbbbnSSSSSS"));
        assertEquals("", PackRLE.encode(""));
        assertEquals("qwerty", PackRLE.encode("qwerty"));
        assertEquals("12WB12W3B24WB14W", PackRLE.encode("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW"));
        assertEquals("QQQQQQQQQQQMNMNQQQQQQQQQQQQQMNQQQQQQQQQQ" ,
                PackRLE.decode(PackRLE.encode("QQQQQQQQQQQMNMNQQQQQQQQQQQQQMNQQQQQQQQQQ"))
        );
        assertEquals("12E10bM11Z", PackRLE.encode("EEEEEEEEEEEEbbbbbbbbbbMZZZZZZZZZZZ"));

    }
}
