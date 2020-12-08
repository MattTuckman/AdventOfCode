package com.tuckman.advent.of.code.day.f;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackySacker {

    private Pattern SACK_RULE_PAT = Pattern.compile("(\\d+) (\\w* \\w*) bag");

    private static final String SHINY_GOLD = "shiny gold";

    public Set<String> sacksContainingGold(List<String> sackRules) {
        Map<String, Set<String>> rulesMap = new HashMap<>();

        for (String rule : sackRules) {
            addRulesToMap(rule, rulesMap);
        }

        Set<String> resultColors = new HashSet<>();
        collectSacksWithGold(SHINY_GOLD, resultColors, rulesMap);

        return resultColors;
    }

    private void collectSacksWithGold(String currentRule, Set<String> resultColors, Map<String, Set<String>> rulesMap) {
        Set<String> currColors = rulesMap.get(currentRule);

        if (currColors == null) {
            return;
        }

        for (String currColor : currColors) {
            if (!resultColors.contains(currColor)) {
                resultColors.add(currColor);
                collectSacksWithGold(currColor, resultColors, rulesMap);
            }
        }
    }

    private void addRulesToMap(String rule, Map<String, Set<String>> ruleMap) {
        if (rule.contains("contain no other bags")) {
            return;
        }

        int indexOfFirstColorEnd = rule.indexOf(" bags");
        String mainColor = rule.substring(0, indexOfFirstColorEnd);

        Matcher matcher = SACK_RULE_PAT.matcher(rule);

        while (matcher.find()) {
            String ruleColor = matcher.group(2);

            if (ruleMap.containsKey(ruleColor)) {
                ruleMap.get(ruleColor).add(mainColor);
            } else {
                Set<String> mainColorSet = new HashSet<>();
                mainColorSet.add(mainColor);
                ruleMap.put(ruleColor, mainColorSet);
            }
        }
    }

    public long bagsInGoldBag(List<String> sackRules) {
        Map<String, List<SackRule>> rulesMap = new HashMap<>();

        for (String rule : sackRules) {
            MainSack currMainSack = formMainSackFromRule(rule);

            if (rulesMap.containsKey(currMainSack.mainColor)) {
                throw new RuntimeException("This shouldn't be here lmao...");
            } else {
                rulesMap.put(currMainSack.getMainColor(), currMainSack.getRules());
            }
        }

        return calculateBagsInColor(SHINY_GOLD, rulesMap);
    }

    private long calculateBagsInColor(String currentColor, Map<String, List<SackRule>> rulesMap) {
        List<SackRule> currRules = rulesMap.get(currentColor);
        if (currRules.isEmpty()) {
            return 0;
        }

        long bagsTotal = 0L;
        for (SackRule sackRule : currRules) {
            bagsTotal += sackRule.getCount();
            bagsTotal += sackRule.getCount() * calculateBagsInColor(sackRule.getColor(), rulesMap);
        }
        return bagsTotal;
    }

    private MainSack formMainSackFromRule(String rule) {
        int indexOfFirstColorEnd = rule.indexOf(" bags");
        String mainColor = rule.substring(0, indexOfFirstColorEnd);

        Matcher matcher = SACK_RULE_PAT.matcher(rule);
        List<SackRule> sackRules = new ArrayList<>();
        while (matcher.find()) {
            int ruleNumber = Integer.parseInt(matcher.group(1));
            String ruleColor = matcher.group(2);
            sackRules.add(new SackRule(ruleColor, ruleNumber));
        }
        return new MainSack(mainColor, sackRules);
    }

    @Setter
    @Getter
    @AllArgsConstructor
    private class SackRule {
        private String color;
        private Integer count;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    private class MainSack {
        private String mainColor;
        private List<SackRule> rules;
    }
}
