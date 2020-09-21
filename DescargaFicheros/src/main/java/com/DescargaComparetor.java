package com;

import java.util.Comparator;

public class DescargaComparetor implements Comparator <Descarga> {


    @Override
    public int compare(Descarga o1, Descarga o2) {
        if(o1.getTiempoDescarga() > o2.getTiempoDescarga()){
            return  1;
        }
        if(o1.getTiempoDescarga() < o2.getTiempoDescarga()){
            return -1;
        }
        return 0;
    }
}
