import jdk.nashorn.internal.ir.debug.JSONWriter;

import java.util.Arrays;

/**
 * Author: AncientAnton
 * Date: 2018/7/30.
 * Description:
 *
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

 字符          数值
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 例如， 罗马数字 2 写做 II ，即为两个并列的 1。
 12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例.
 例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

 I 可以放在 V (5) 和 X (10) 的左边，来表示 4(IV) 和 9(IX)。
 X 可以放在 L (50) 和 C (100) 的左边，来表示 40(XL) 和 90(XC)。
 C 可以放在 D (500) 和 M (1000) 的左边，来表示 400(CD) 和 900(CM)。
 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder(20);
        if (num >= 1000) {
            for (int i = 0; i < num / 1000; ++i) builder.append('M');
            num %= 1000;
        }
        if (num >= 900) {
            builder.append('C');
            builder.append('M');
            num -= 900;
        }
        if (num >= 500) {
            builder.append('D');
            num -= 500;
        }
        if (num >= 400) {
            builder.append('C');
            builder.append('D');
            num -= 400;
        }
        if (num >= 100) {
            for (int i = 0; i < num / 100; ++i) builder.append('C');
            num %= 100;
        }
        if (num >= 90) {
            builder.append('X');
            builder.append('C');
            num -= 90;
        }
        if (num >= 50) {
            builder.append('L');
            num -= 50;
        }
        if (num >= 40) {
            builder.append('X');
            builder.append('L');
            num -= 40;
        }
        if (num >= 10) {
            for (int i = 0; i < num / 10; ++i) builder.append('X');
            num %= 10;
        }
        switch (num) {
            case 9:
                builder.append('I');
                builder.append('X');
                break;
            case 8:
                builder.append('V');
                builder.append('I');
                builder.append('I');
                builder.append('I');
                break;
            case 7:
                builder.append('V');
                builder.append('I');
                builder.append('I');
                break;
            case 6:
                builder.append('V');
                builder.append('I');
                break;
            case 5:
                builder.append('V');
                break;
            case 4:
                builder.append('I');
                builder.append('V');
                break;
            case 3:
                builder.append('I');
                builder.append('I');
                builder.append('I');
                break;
            case 2:
                builder.append('I');
                builder.append('I');
                break;
            case 1:
                builder.append('I');
                break;
            default:
                break;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman solution = new IntegerToRoman();
        System.out.print(solution.intToRoman(1995));
    }
}
