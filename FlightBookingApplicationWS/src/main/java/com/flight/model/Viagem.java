package com.flight.model;

import java.io.Serializable;
import java.util.Arrays;

import static com.flight.model.TipoBilhete.ECONOMICO;
import static com.flight.model.TipoBilhete.EXECUTIVO;

public class Viagem implements Serializable {
    private static int counter=0;
    private int counterNum;
    private String nomeViagem;
    BilheteList bilhetesParaVender;
    BilheteList bilhetesVendidos;
    Companhia companhia;
    int lugaresTotais;
    String cidadeFinal;
    String cidadeInicial;

    Data dataPartida;
    Data dataChegada;

    Horario horaPartida;

    Horario horaChegada;

    int lugaresEconomicos;
    int lugaresExecutivos;
    int lugaresPrimeiraClasse;

    private String[] cidades_possiveis = new String [] {"Portugal","Vienna", "Salzburg", "Baku", "Ganja", "Minsk", "Gomel", "Brussels", "Antwerp", "Sarajevo", "Banja Luka", "Sofia", "Varna", "Zagreb", "Split", "Nicosia", "Larnaca", "Prague", "Brno", "Copenhagen", "Billund", "Tallinn", "Tartu", "Helsinki", "Turku", "Bordeaux", "Nice", "Berlin", "Munich", "Athens", "Thessaloniki", "Budapest", "Debrecen", "Reykjavik", "Keflavik", "Dublin", "Cork", "Rome", "Milan", "Pristina", "Përnambuc", "Riga", "Liepāja", "Vilnius", "Kaunas", "Luxembourg City", "Esch-sur-Alzette", "Valletta", "Gozo", "Chisinau", "Bălți", "Monaco", "Monte Carlo", "Podgorica", "Tivat", "Amsterdam", "Rotterdam", "Oslo", "Bergen", "Kraków", "Warsaw", "Lisboa", "Porto", "Bucharest", "Cluj-Napoca", "Moscow", "St. Petersburg", "Belgrade", "Niš", "Bratislava", "Košice", "Ljubljana", "Maribor", "Madrid", "Barcelona", "Stockholm", "Gothenburg", "Bern", "Zurich", "Istanbul", "Ankara", "Kyiv", "Lviv", "Liverpool", "Manchester", "London", "Manchester", "Zagreb", "Split", "Paris", "Nice", "Athens", "Thessaloniki"};

    public Viagem(Companhia companhia, int lugaresTotais, String cidadeInicial, String cidadeFinal, Data dataPartida, Data dataChegada, Horario horaPartida,Horario horaChegada, int lugaresEconomicos, int lugaresExecutivos, int lugaresPrimeiraClasse) {
        try {
            counter++;
            counterNum= counter;
            this.companhia = companhia;
            //NAO COLOCAR MUITOS LUGARES TOTAIS, CASO CONTRARIO O PC DEMORA MUITO A CONSTRUIR OS BILHETES TODOS
            if (lugaresTotais > 10 && lugaresTotais < 50) {
                this.lugaresTotais = lugaresTotais;
            } else {
                //throw new numeroMaxLugaresInvalidos;
                throw new Exception();
            }
            //this.cidadeInicial = cidadeInicial;
            setCidadeFinal(cidadeFinal);
            setCidadeInicial(cidadeInicial);
            if (dataChegada.isGreaterThan(dataPartida)) {
                this.dataPartida = dataPartida;
                this.dataChegada = dataChegada;
            } else {
                //throw new datachegadaantesdataPartida
                throw new Exception();
            }
            if(Horario.eValidaHora(horaPartida.getHora(), horaPartida.getMinuto()) && Horario.eValidaHora(horaChegada.getHora(), horaChegada.getMinuto())){
                setHoraPartida(horaPartida);
                setHoraChegada(horaChegada);
            }
            if (horaChegada.isGreaterThan(horaPartida)) {
                this.horaPartida = horaPartida;
                this.horaChegada = horaChegada;
            } else {
                //throw new datachegadaantesdataPartida
                throw new Exception();
            }

            if (lugaresEconomicos > lugaresExecutivos && lugaresExecutivos > lugaresPrimeiraClasse && lugaresEconomicos + lugaresExecutivos + lugaresPrimeiraClasse == lugaresTotais) {
                this.lugaresEconomicos = lugaresEconomicos;
                this.lugaresExecutivos = lugaresExecutivos;
                this.lugaresPrimeiraClasse = lugaresPrimeiraClasse;
            } else {
                //throw new lugaresInvalidos
                throw new Exception();
            }
            this.nomeViagem = setNomeViagem(cidadeFinal, cidadeInicial, counterNum);
            BilheteList b = new BilheteList(nomeViagem, lugaresTotais, lugaresEconomicos, lugaresExecutivos, lugaresPrimeiraClasse);
            bilhetesParaVender = b;
            bilhetesVendidos = new BilheteList();
        }catch (Exception e) {}
    }

    public boolean validadeCidade(String cidade) {
        if(Arrays.asList(cidades_possiveis).contains(cidade)) {
            return true;
        } return false;
    }

    public String setNomeViagem(String cidadeFinal, String cidadeInicial, int counter) {
        char a1  =cidadeInicial.charAt(0) ;
        char b1  =cidadeInicial.charAt(1) ;
        char c1  =cidadeInicial.charAt(2) ;
        char a2  =cidadeFinal.charAt(0) ;
        char b2  =cidadeFinal.charAt(1) ;
        char c2  =cidadeFinal.charAt(2) ;
        String nomeViagem1 = new String(new char[]{a1,b1,c1});
        String nomeViagem2 = new String(new char[]{a2,b2,c2});
        String nomeViagem = nomeViagem1+"x"+nomeViagem2+counter;
        return nomeViagem;
    }

    public String getNomeViagem() {
        return nomeViagem;
    }
    public int getLugaresTotais() {
        return lugaresTotais;
    }
    public void setLugaresTotais(int lugaresTotais) {
        this.lugaresTotais = lugaresTotais;
    }
    public String getCidadeFinal() {
        return cidadeFinal;
    }
    public void setCidadeFinal(String cidadeFinal) {
        if(validadeCidade(cidadeFinal)){
            this.cidadeFinal = cidadeFinal;
        } else {
            String msg ="Cidade invalida";
            throw new RuntimeException(msg);
        }
    }
    public String getCidadeInicial() {
        return cidadeInicial;
    }
    public void setCidadeInicial(String cidadeInicial) {
        if(validadeCidade(cidadeInicial)){
            this.cidadeInicial = cidadeInicial;
        } else {
            String msg ="Cidade invalida";
            throw new RuntimeException(msg);
        }
    }

    public void alterarNumerosLugar(FBS fbs,Bilhete b) {
        if(b.getTipoBilhete().equals(ECONOMICO)){
            int i = fbs.getViagemList().getViagemByNomeViagem(nomeViagem).getLugaresEconomicos()+1;
            fbs.getViagemList().getViagemByNomeViagem(nomeViagem).setLugaresEconomicos(i);
        }
        if(b.getTipoBilhete().equals(EXECUTIVO)){
            int i = fbs.getViagemList().getViagemByNomeViagem(nomeViagem).getLugaresExecutivos()+1;
            fbs.getViagemList().getViagemByNomeViagem(nomeViagem).setLugaresExecutivos(i);
        }
        if(b.getTipoBilhete().equals(EXECUTIVO)){
            int i = fbs.getViagemList().getViagemByNomeViagem(nomeViagem).getLugaresEconomicos()+1;
            fbs.getViagemList().getViagemByNomeViagem(nomeViagem).setLugaresEconomicos(i);
        }
    }

    public Data getDataPartida() {
        return dataPartida;
    }
    public void setDataPartida(Data dataPartida) {
        this.dataPartida = dataPartida;
    }
    public Data getDataChegada() {
        return dataChegada;
    }
    public void setDataChegada(Data dataChegada) {
        this.dataChegada = dataChegada;
    }
    public int getLugaresEconomicos() {
        return lugaresEconomicos;
    }
    public int getLugaresExecutivos() {
        return lugaresExecutivos;
    }
    public int getLugaresPrimeiraClasse() {
        return lugaresPrimeiraClasse;
    }

    public void setLugaresEconomicos(int lugaresEconomicos) {
        this.lugaresEconomicos = lugaresEconomicos;
    }
    public void setLugaresExecutivos(int lugaresExecutivos) {
        this.lugaresExecutivos = lugaresExecutivos;
    }

    public void setLugaresPrimeiraClasse(int lugaresPrimeiraClasse) {
        this.lugaresPrimeiraClasse = lugaresPrimeiraClasse;
    }
    public Companhia getCompanhia() {
        return companhia;
    }
    public void setCompanhia(Companhia companhia) {
        this.companhia = companhia;
    }


    public BilheteList getBilhetesParaVender() {
        return bilhetesParaVender;
    }
    public void setBilhetesParaVender(BilheteList bilhetesParaVender) {
        this.bilhetesParaVender = bilhetesParaVender;
    }

    public BilheteList getBilhetesVendidos() {
        return bilhetesVendidos;
    }

    public void setBilhetesVendidos(BilheteList bilhetesVendidos) {
        this.bilhetesVendidos = bilhetesVendidos;
    }

    public Horario getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(Horario horaPartida) {
        this.horaPartida = horaPartida;
    }

    public Horario getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(Horario horaChegada) {
        this.horaChegada = horaChegada;
    }
}
