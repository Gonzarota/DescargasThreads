package com;


public class Main {

    public static void main(String[] args) {

        Descarga archivo1=new Descarga("http://mirrors.kernel.org/ubuntu/pool/main/m/mysql-5.7/mysql-server-5.7_5.7.31-0ubuntu0.16.04.1_amd64.deb","archivo1.deb");
        Descarga archivo2=new Descarga("http://ftp.osuosl.org/pub/ubuntu/pool/main/m/mysql-5.7/mysql-server-5.7_5.7.31-0ubuntu0.16.04.1_amd64.deb","archivo2.deb");
        Descarga archivo3=new Descarga("http://za.archive.ubuntu.com/ubuntu/pool/main/m/mysql-5.7/mysql-server-5.7_5.7.31-0ubuntu0.16.04.1_amd64.deb","archivo3.deb");

        AdminDescargas admin=new AdminDescargas();

        admin.addDescarga(archivo1);
        admin.addDescarga(archivo2);
        admin.addDescarga(archivo3);

        admin.ordenarDescargas();

    }
}
