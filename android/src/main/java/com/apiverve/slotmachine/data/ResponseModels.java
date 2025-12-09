// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     SlotMachineSimulatorData data = Converter.fromJsonString(jsonString);

package com.apiverve.slotmachine.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static SlotMachineSimulatorData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(SlotMachineSimulatorData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(SlotMachineSimulatorData.class);
        writer = mapper.writerFor(SlotMachineSimulatorData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// SlotMachineSimulatorData.java

package com.apiverve.slotmachine.data;

import com.fasterxml.jackson.annotation.*;

public class SlotMachineSimulatorData {
    private long totalSpins;
    private long numReels;
    private long betPerSpin;
    private Spin[] spins;
    private long totalBet;
    private long totalWinnings;
    private long netProfit;
    private long wins;
    private long losses;
    private long winPercentage;
    private AvailableSymbol[] availableSymbols;

    @JsonProperty("total_spins")
    public long getTotalSpins() { return totalSpins; }
    @JsonProperty("total_spins")
    public void setTotalSpins(long value) { this.totalSpins = value; }

    @JsonProperty("num_reels")
    public long getNumReels() { return numReels; }
    @JsonProperty("num_reels")
    public void setNumReels(long value) { this.numReels = value; }

    @JsonProperty("bet_per_spin")
    public long getBetPerSpin() { return betPerSpin; }
    @JsonProperty("bet_per_spin")
    public void setBetPerSpin(long value) { this.betPerSpin = value; }

    @JsonProperty("spins")
    public Spin[] getSpins() { return spins; }
    @JsonProperty("spins")
    public void setSpins(Spin[] value) { this.spins = value; }

    @JsonProperty("total_bet")
    public long getTotalBet() { return totalBet; }
    @JsonProperty("total_bet")
    public void setTotalBet(long value) { this.totalBet = value; }

    @JsonProperty("total_winnings")
    public long getTotalWinnings() { return totalWinnings; }
    @JsonProperty("total_winnings")
    public void setTotalWinnings(long value) { this.totalWinnings = value; }

    @JsonProperty("net_profit")
    public long getNetProfit() { return netProfit; }
    @JsonProperty("net_profit")
    public void setNetProfit(long value) { this.netProfit = value; }

    @JsonProperty("wins")
    public long getWINS() { return wins; }
    @JsonProperty("wins")
    public void setWINS(long value) { this.wins = value; }

    @JsonProperty("losses")
    public long getLosses() { return losses; }
    @JsonProperty("losses")
    public void setLosses(long value) { this.losses = value; }

    @JsonProperty("win_percentage")
    public long getWinPercentage() { return winPercentage; }
    @JsonProperty("win_percentage")
    public void setWinPercentage(long value) { this.winPercentage = value; }

    @JsonProperty("available_symbols")
    public AvailableSymbol[] getAvailableSymbols() { return availableSymbols; }
    @JsonProperty("available_symbols")
    public void setAvailableSymbols(AvailableSymbol[] value) { this.availableSymbols = value; }
}

// AvailableSymbol.java

package com.apiverve.slotmachine.data;

import com.fasterxml.jackson.annotation.*;

public class AvailableSymbol {
    private String symbol;
    private String name;
    private long payoutMultiplier;

    @JsonProperty("symbol")
    public String getSymbol() { return symbol; }
    @JsonProperty("symbol")
    public void setSymbol(String value) { this.symbol = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("payout_multiplier")
    public long getPayoutMultiplier() { return payoutMultiplier; }
    @JsonProperty("payout_multiplier")
    public void setPayoutMultiplier(long value) { this.payoutMultiplier = value; }
}

// Spin.java

package com.apiverve.slotmachine.data;

import com.fasterxml.jackson.annotation.*;

public class Spin {
    private long spinNumber;
    private Reel[] reels;
    private long bet;
    private long payout;
    private String winType;
    private boolean isWin;

    @JsonProperty("spin_number")
    public long getSpinNumber() { return spinNumber; }
    @JsonProperty("spin_number")
    public void setSpinNumber(long value) { this.spinNumber = value; }

    @JsonProperty("reels")
    public Reel[] getReels() { return reels; }
    @JsonProperty("reels")
    public void setReels(Reel[] value) { this.reels = value; }

    @JsonProperty("bet")
    public long getBet() { return bet; }
    @JsonProperty("bet")
    public void setBet(long value) { this.bet = value; }

    @JsonProperty("payout")
    public long getPayout() { return payout; }
    @JsonProperty("payout")
    public void setPayout(long value) { this.payout = value; }

    @JsonProperty("win_type")
    public String getWinType() { return winType; }
    @JsonProperty("win_type")
    public void setWinType(String value) { this.winType = value; }

    @JsonProperty("is_win")
    public boolean getIsWin() { return isWin; }
    @JsonProperty("is_win")
    public void setIsWin(boolean value) { this.isWin = value; }
}

// Reel.java

package com.apiverve.slotmachine.data;

import com.fasterxml.jackson.annotation.*;

public class Reel {
    private String symbol;
    private String name;

    @JsonProperty("symbol")
    public String getSymbol() { return symbol; }
    @JsonProperty("symbol")
    public void setSymbol(String value) { this.symbol = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }
}