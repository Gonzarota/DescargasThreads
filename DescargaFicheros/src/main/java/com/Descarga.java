package com;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class Descarga extends  Thread{

    private String url;
    private String nombreArchivo;
    private long tiempoDescarga;

    public Descarga(String url,String nombreArchivo){
        this.url=url;
        this.nombreArchivo=nombreArchivo;
    }

    @Override
    public void run(){
        long tiempoInicial=System.currentTimeMillis();
        try {
            ReadableByteChannel readableByteChannel= Channels.newChannel(new URL(this.url).openStream());
            FileOutputStream fileOutputStream=new FileOutputStream(this.nombreArchivo);
            FileChannel fileChannel=fileOutputStream.getChannel();
            fileChannel.transferFrom(readableByteChannel,0,Long.MAX_VALUE);

            long tiempoFinal=System.currentTimeMillis();
            this.tiempoDescarga=tiempoFinal-tiempoInicial;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long getTiempoDescarga() {
        return tiempoDescarga;
    }

    public String getUrl() {
        return url;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }
}
