package mariosPizza.ui;

import java.util.ArrayList;
import java.util.List;

public class PrintMenuOperations {
    private String yellow = "\u001B[33m";
    private String buildItem(String content, int itemIndex, boolean printDelimiter){
        var item = String.format("[%d] %s %s",itemIndex,content, printDelimiter ? "| " : "");
        return item;
    }

    private List<String> buildItems(){
        int itemIndex = 1;
        var items = new ArrayList<String>();
        items.add(buildItem("Create new order",itemIndex++,true));
        items.add(buildItem("Print list of orders",itemIndex++,true));
        items.add(buildItem("Show menu card",itemIndex++,true));
        items.add(buildItem("Cancel order",itemIndex++,true));
        items.add(buildItem("Mark order as finished",itemIndex++,true));
        items.add(buildItem("Exit program",itemIndex++,false));
        return items;
    }

    private int aggregatedLength(List<String> items){
        var aggregatedLength = items.stream()
                .map(String::length)
                .reduce(0,(x,y) -> y += x);
        return aggregatedLength;
    }

    private String buildHeader(int length){
        var header = new StringBuilder("\33[33m");
        var label = "MENU";
        var lengthOfDots = length - label.length();
        for (var i = 0;i < lengthOfDots - 1;i++)
            header.append("-");
        int medianIndex;
        if(lengthOfDots % 2 == 0)
            medianIndex = lengthOfDots / 2;
        else
            medianIndex = (lengthOfDots / 2) + 1;
        header.insert(medianIndex,label);
        header.append("\33[m");
        return header.toString();
    }

    public void print(){
        var items = buildItems();
        var lengthOfItems = aggregatedLength(items);
        var header = buildHeader(lengthOfItems);
        System.out.println(header);
        items.forEach(s -> System.out.print(s));
    }
}
