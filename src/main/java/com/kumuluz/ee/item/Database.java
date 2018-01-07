/*
 *  Copyright (c) 2014-2017 Kumuluz and/or its affiliates
 *  and other contributors as indicated by the @author tags and
 *  the contributor list.
 *
 *  Licensed under the MIT License (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  https://opensource.org/licenses/MIT
 *
 *  The software is provided "AS IS", WITHOUT WARRANTY OF ANY KIND, express or
 *  implied, including but not limited to the warranties of merchantability,
 *  fitness for a particular purpose and noninfringement. in no event shall the
 *  authors or copyright holders be liable for any claim, damages or other
 *  liability, whether in an action of contract, tort or otherwise, arising from,
 *  out of or in connection with the software or the use or other dealings in the
 *  software. See the License for the specific language governing permissions and
 *  limitations under the License.
*/
package com.kumuluz.ee.item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Database {
    private static List<Item> items = new ArrayList<>(
            Arrays.asList(
                    new Item("1", "Nova unifroma", "ful je dobra", "1"),
                    new Item("2", "Stara uniforma", "ful ni glih dobra", "2"),
                    new Item("3", "Križ", "mau je znucan ampak za molt je dobr", "2"),
                    new Item("4", "Čips Chio s sirom", "u klet smo ga najdl, rok je preteku", "2"),
                    new Item("5", "Daljinec MOTOROLA", "Univerzalni MOTOROLA daljinec za vse vrste TVjev", "1"),
                    new Item("6", "Cement", "1 vrečka", "1")
            )
    );

    public static void initDatabase() {

    }


    public static List<Item> getItems() {
        return items;
    }

    public static Item getItem(String id) {

        for (Item item : items) {
            if (item.getId().equals(id))
                return item;
        }

        return null;
    }


    public static void addItem(Item item) {
        items.add(item);
    }

    public static void deleteItem(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                items.remove(item);
                break;
            }
        }
    }
}
