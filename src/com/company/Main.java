package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(IPv4Uint32ToString(2149583360L));
        System.out.println(ipv4StringToUInt32("0.0.0.255"));
    }

    //В джава нет беззнаковых типов. поэтому операции с типов int32 эмулировались с помощью побитовых операций
    //в обычыный джава инт айпи адрес больше чем 127.255.255.255 не поместится
    public static long ipv4StringToUInt32(String ipAddress) {
        String[] octets = ipAddress.split("\\.");
        long result = 0;
        for (int i = 0; i < 4; i++) {
            long octet = Integer.parseInt(octets[i]);
            result |= octet << ((3 - i) * 8);
            //переменная октет сдвигается на 8 бит влево 3 - i раз(аналог умножения на 256 в 3 - i степени)
            //|= побитово записывает результат вышеописанной операции в результирующую операцию
        }
        return result;
    }

    public static String IPv4Uint32ToString(long ipAddress) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int octet = (int) ((ipAddress >> ((3 - i) * 8)) & 0xff); //11111111b.эта операция обратная прошлой
            sb.append(octet);
            if (i < 3) {
                sb.append(".");
            }
        }
        return sb.toString();
    }


}
