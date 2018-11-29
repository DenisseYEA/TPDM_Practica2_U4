package mx.edu.ittepic.practica2_u4_denisseespinosa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView jugador,ganador;
    Thread cpu;
    Button x1,x2,x3,x4,x5,x6,x7,x8,x9,iniciar,reiniciar;
    String arr[][] = {{"0","0","0"},{"0","0","0"},{"0","0","0"}};
    int j,c,jcpu=1;
    boolean ganadorr, statuss = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jugador = findViewById(R.id.jugador);
        ganador = findViewById(R.id.ganador);
        iniciar = findViewById(R.id.iniciar);
        reiniciar = findViewById(R.id.reiniciar);
        x1 = findViewById(R.id.x1);
        x2 = findViewById(R.id.x2);
        x3 = findViewById(R.id.x3);
        x4 = findViewById(R.id.x4);
        x5 = findViewById(R.id.x5);
        x6 = findViewById(R.id.x6);
        x7 = findViewById(R.id.x7);
        x8 = findViewById(R.id.x8);
        x9 = findViewById(R.id.x9);
        reiniciar.setVisibility(View.GONE);
        clickable();

        cpu = new Thread(){
            @Override
            public void run() {
                while (statuss){
                    while (jcpu < 1 && ganadorr == false){
                        jcpu = 1;
                        j = 1;
                        try {
                            sleep(2000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                jugadorCPU();
                                c+=1;
                                ganadorr = finx();
                                if (ganadorr == true) {
                                    return;
                                }
                                jugador.setText("JUGADOR");
                            }
                        });
                    }

                }
            }
        };

    }

    private void jugadorCPU(){
        boolean status = false;
        status = tirogt("O");
        if (status == true){
            return;
        }
        status = tirogt("X");
        if (status == true){
            return;
        }
        int u[] = {1,2,3,4};
        int index, temp;
        Random random = new Random();
        for (int i = u.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = u[index];
            u[index] = u[i];
            u[i] = temp;
        }

        int v[] = {1,2,3,4,5};
        for (int i = v.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp =v[index];
            v[index] = v[i];
            v[i] = temp;
        }

        status = ejecutar4(u[0]);
        if (status == true){
            jugador.setText("JUGADOR");
            return;
        }
        status = ejecutar4(u[1]);
        if (status == true){
            jugador.setText("JUGADOR");
            return;
        }
        status = ejecutar4(u[2]);
        if (status == true){
            jugador.setText("JUGADOR");
            return;
        }
        status = ejecutar4(u[3]);
        if (status == true){
            jugador.setText("JUGADOR");
            return;
        }

        status = ejecutar5(v[0]);
        if (status == true){
            jugador.setText("JUGADOR");
            return;
        }
        status = ejecutar5(v[1]);
        if (status == true){
            jugador.setText("JUGADOR");
            return;
        }
        status = ejecutar5(v[2]);
        if (status == true){
            jugador.setText("JUGADOR");
            return;
        }
        status = ejecutar5(v[3]);
        if (status == true){
            jugador.setText("JUGADOR");
            return;
        }
        status = ejecutar5(v[4]);
        if (status == true){
            jugador.setText("JUGADOR");
            return;
        }

    }

    private void clickable(){
        x1.setClickable(false);
        x2.setClickable(false);
        x3.setClickable(false);
        x4.setClickable(false);
        x5.setClickable(false);
        x6.setClickable(false);
        x7.setClickable(false);
        x8.setClickable(false);
        x9.setClickable(false);
    }

    public void iniciar(View v){
        jugador.setText("JUGADOR");
        j = 0;
        c = 0;
        reiniciar.setVisibility(View.VISIBLE);
        iniciar.setVisibility(View.GONE);
        x1.setClickable(true);
        x2.setClickable(true);
        x3.setClickable(true);
        x4.setClickable(true);
        x5.setClickable(true);
        x6.setClickable(true);
        x7.setClickable(true);
        x8.setClickable(true);
        x9.setClickable(true);
        cpu.start();
    }

    public void reiniciar(View v){
        arr[0][0]="0";
        arr[0][1]="0";
        arr[0][2]="0";
        arr[1][0]="0";
        arr[1][1]="0";
        arr[1][2]="0";
        arr[2][0]="0";
        arr[2][1]="0";
        arr[2][2]="0";
        x1.setText("");
        x2.setText("");
        x3.setText("");
        x4.setText("");
        x5.setText("");
        x6.setText("");
        x7.setText("");
        x9.setText("");
        x8.setText("");
        jugador.setText("");
        ganador.setText("");
        clickable();
        jugador.setText("JUGADOR");
        j = 0;
        c = 0;
        x1.setClickable(true);
        x2.setClickable(true);
        x3.setClickable(true);
        x4.setClickable(true);
        x5.setClickable(true);
        x6.setClickable(true);
        x7.setClickable(true);
        x8.setClickable(true);
        x9.setClickable(true);
    }

    public void btnx1(View v){
        j = 0;
        x1.setText("X");
            arr[0][0]="X";
            x1.setClickable(false);
            ganadorr = false;
            c+=1;
            ganadorr = finx();
            if (ganadorr == true){
                return;
            }else {
                jugador.setText("CPU");
                jcpu = 0;
            }
    }

    public void btnx2(View v){
        j = 0;
        x2.setText("X");
            x2.setClickable(false);
            arr[0][1]="X";
            ganadorr = false;
            c+=1;
            ganadorr = finx();
            if (ganadorr == true){
                return;
            }else {
                jugador.setText("CPU");
                jcpu = 0;
            }
    }

    public void btnx3(View v){
        j = 0;
        x3.setText("X");
            x3.setClickable(false);
            arr[0][2]="X";
            ganadorr = false;
            c+=1;
            ganadorr = finx();
            if (ganadorr == true){
                return;
            }else {
                jugador.setText("CPU");
                jcpu = 0;
            }
    }

    public void btnx4(View v){
        j = 0;
        x4.setText("X");
            x4.setClickable(false);
            arr[1][0]="X";
            ganadorr = false;
            c+=1;
            ganadorr = finx();
            if (ganadorr == true){
                return;
            }else {
                jugador.setText("CPU");
                jcpu = 0;
            }
    }

    public void btnx5(View v){
        j = 0;
        x5.setText("X");
            x5.setClickable(false);
            arr[1][1]="X";
            ganadorr = false;
            c+=1;
            ganadorr = finx();
            if (ganadorr == true){
                return;
            }else {
                jugador.setText("CPU");
                jcpu = 0;
            }
    }

    public void btnx6(View v){
        j = 0;
        x6.setText("X");
            x6.setClickable(false);
            arr[1][2]="X";
            ganadorr = false;
            c+=1;
            ganadorr = finx();
            if (ganadorr == true){
                return;
            }else {
                jugador.setText("CPU");
                jcpu = 0;
            }
    }

    public void btnx7(View v){
        j = 0;
        x7.setText("X");
            x7.setClickable(false);
            arr[2][0]="X";
            ganadorr = false;
            c+=1;
            ganadorr = finx();
            if (ganadorr == true){
                return;
            }else {
                jugador.setText("CPU");
                jcpu = 0;
            }
    }

    public void btnx8(View v){
        j = 0;
        x8.setText("X");
            x8.setClickable(false);
            arr[2][1]="X";
            ganadorr = false;
            c+=1;
            ganadorr = finx();
            if (ganadorr == true){
                return;
            }else {
                jugador.setText("CPU");
                jcpu = 0;
            }
    }

    public void btnx9(View v) {
        j = 0;
        x9.setText("X");
            x9.setClickable(false);
            arr[2][2]="X";
            ganadorr = false;
            c+=1;
            ganadorr = finx();
            if (ganadorr == true){
                return;
            }else {
                jugador.setText("CPU");
                jcpu = 0;
            }
    }


    private boolean ejecutar4(int x){
        if (x == 1){
            if (arr[0][0].equals("0")){
                x1.setText("O");
                x1.setClickable(false);
                arr[0][0] = "O";
                return true;
            }
        }

        if (x == 2){
            if (arr[0][2].equals("0")){
                x3.setText("O");
                x3.setClickable(false);
                arr[0][2] = "O";
                return true;
            }
        }

        if (x == 3){
            if (arr[2][0].equals("0")){
                x7.setText("O");
                x7.setClickable(false);
                arr[2][0] = "O";
                return true;
            }
        }

        if (x == 4){
            if (arr[2][2].equals("0")){
                x9.setText("O");
                x9.setClickable(false);
                arr[2][2] = "O";
                return true;
            }
        }
        return false;
    }

    private boolean ejecutar5(int x){
        if (x == 1){
            if (arr[0][1].equals("0")){
                x2.setText("O");
                x2.setClickable(false);
                arr[0][1] = "O";
                return true;
            }
        }
        if (x == 2){
            if (arr[1][0].equals("0")){
                x4.setText("O");
                x4.setClickable(false);
                arr[1][0] = "O";
                return true;
            }
        }
        if (x == 3){
            if (arr[1][1].equals("0")){
                x5.setText("O");
                x5.setClickable(false);
                arr[1][1] = "O";
                return true;
            }
        }
        if (x == 4){
            if (arr[1][2].equals("0")){
                x6.setText("O");
                x6.setClickable(false);
                arr[1][2] = "O";
                return true;
            }
        }
        if (x == 5){
            if (arr[2][1].equals("0")){
                x8.setText("O");
                x8.setClickable(false);
                arr[2][1] = "O";
                return true;
            }
        }
        return false;
    }

    private boolean tirogt(String valor){
        int b[] = {1,2};
        int index, temp;
        Random random = new Random();
        for (int i = b.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = b[index];
            b[index] = b[i];
            b[i] = temp;
        }
        boolean status = false;
        status = ejecutar(b[0],valor);
        if (status == true){
            return true;
        }
        status = ejecutar(b[1],valor);
        if (status == true){
            return true;
        }
        return false;
    }

    private boolean ejecutar(int x,String valor){
        if (x == 1){
            for (int i = 0; i<3; i++){
                int b[] = {1,2,3,4,5,6};
                int index, temp;
                Random random = new Random();
                for (int j = b.length - 1; j > 0; j--)
                {
                    index = random.nextInt(j + 1);
                    temp = b[index];
                    b[index] = b[j];
                    b[j] = temp;
                }
                boolean status = false;
                status = ejecutar2(b[0],i,valor);
                if (status == true){
                    return true;
                }
                status = ejecutar2(b[1],i,valor);
                if (status == true){
                    return true;
                }
                status = ejecutar2(b[2],i,valor);
                if (status == true){
                    return true;
                }
                status = ejecutar2(b[3],i,valor);
                if (status == true){
                    return true;
                }
                status = ejecutar2(b[4],i,valor);
                if (status == true){
                    return true;
                }
                status = ejecutar2(b[5],i,valor);
                if (status == true){
                    return true;
                }
            }
        }else{
            int b[] = {1,2,3,4,5,6};
            int index, temp;
            Random random = new Random();
            for (int j = b.length - 1; j > 0; j--)
            {
                index = random.nextInt(j + 1);
                temp = b[index];
                b[index] = b[j];
                b[j] = temp;
            }
            boolean status = false;
            status = ejecutar3(b[0],valor);
            if (status == true){
                return true;
            }
            status = ejecutar3(b[1],valor);
            if (status == true){
                return true;
            }
            status = ejecutar3(b[2],valor);
            if (status == true){
                return true;
            }
            status = ejecutar3(b[3],valor);
            if (status == true){
                return true;
            }
            status = ejecutar3(b[4],valor);
            if (status == true){
                return true;
            }
            status = ejecutar3(b[5],valor);
            if (status == true){
                return true;
            }
        }
        return false;
    }

    private boolean ejecutar2(int x, int i, String valor){
        if (x == 1){
            if (arr[i][0].equals(valor) && arr[i][1].equals(valor) && arr[i][2].equals("0")){
                if (i == 0){
                    x3.setText("O");
                    x3.setClickable(false);
                }else if (i == 1){
                    x6.setText("O");
                    x6.setClickable(false);
                }else {
                    x9.setText("O");
                    x9.setClickable(false);
                }
                arr[i][2] = "O";
                return true;
            }
        }

        if (x == 2){
            if (arr[i][0].equals(valor) && arr[i][1].equals("0") && arr[i][2].equals(valor)){
                if (i == 0){
                    x2.setText("O");
                    x2.setClickable(false);
                }else if (i == 1){
                    x5.setText("O");
                    x5.setClickable(false);
                }else {
                    x8.setText("O");
                    x8.setClickable(false);
                }
                arr[i][1]="O";
                return true;
            }
        }

        if (x == 3){
            if (arr[i][0].equals("0") && arr[i][1].equals(valor) && arr[i][2].equals(valor)){
                if (i == 0){
                    x1.setText("O");
                    x1.setClickable(false);
                }else if (i == 1){
                    x4.setText("O");
                    x4.setClickable(false);
                }else {
                    x7.setText("O");
                    x7.setClickable(false);
                }
                arr[i][0] = "O";
                return true;
            }
        }

        if (x == 4){
            if (arr[0][i].equals("0") && arr[1][i].equals(valor) && arr[2][i].equals(valor)){
                if (i == 0){
                    x1.setText("O");
                    x1.setClickable(false);
                }else if (i == 1){
                    x2.setText("O");
                    x2.setClickable(false);
                }else {
                    x3.setText("O");
                    x3.setClickable(false);
                }
                arr[0][i] = "O";
                return true;
            }
        }

        if (x == 5){
            if (arr[0][i].equals(valor) && arr[1][i].equals("0") && arr[2][i].equals(valor)){
                if (i == 0){
                    x4.setText("O");
                    x4.setClickable(false);
                }else if (i == 1){
                    x5.setText("O");
                    x5.setClickable(false);
                }else {
                    x6.setText("O");
                    x6.setClickable(false);
                }
                arr[1][i] = "O";
                return true;
            }
        }

        if (x == 6){
            if (arr[0][i].equals(valor) && arr[1][i].equals(valor) && arr[2][i].equals("0")){
                if (i == 0){
                    x7.setText("O");
                    x7.setClickable(false);
                }else if (i == 1){
                    x8.setText("O");
                    x8.setClickable(false);
                }else {
                    x9.setText("O");
                    x9.setClickable(false);
                }
                arr[2][i] = "O";
                return true;
            }
        }
        return false;
    }

    private boolean ejecutar3(int x,String valor){
        if (x == 1){
            if (arr[0][0].equals("0") && arr[1][1].equals(valor) && arr[2][2].equals(valor)) {
                x1.setText("O");
                x1.setClickable(false);
                arr[0][0] = "O";
                return true;
            }
        }

        if (x == 2){
            if (arr[0][0].equals(valor) && arr[1][1].equals("0") && arr[2][2].equals(valor)){
                x5.setText("O");
                x5.setClickable(false);
                arr[1][1] = "O";
                return true;
            }
        }

        if (x == 3){
            if (arr[0][0].equals(valor) && arr[1][1].equals(valor) && arr[2][2].equals("0")){
                x9.setText("O");
                x9.setClickable(false);
                arr[2][2] = "O";
                return true;
            }
        }

        if (x == 4){
            if (arr[2][0].equals("0") && arr[1][1].equals(valor) && arr[0][2].equals(valor)) {
                x7.setText("O");
                x7.setClickable(false);
                arr[2][0] = "O";
                return true;
            }
        }

        if (x == 5){
            if (arr[2][0].equals(valor) && arr[1][1].equals("0") && arr[0][2].equals(valor)){
                x5.setText("O");
                x5.setClickable(false);
                arr[1][1] = "O";
                return true;
            }
        }

        if (x == 6){
            if (arr[2][0].equals(valor) && arr[1][1].equals(valor) && arr[0][2].equals("0")){
                x3.setText("O");
                x3.setClickable(false);
                arr[0][2] = "O";
                return true;
            }
        }
        return false;
    }

    private boolean finx() {
        String v = "";
        ganador.setText(j+"");
        if (j == 0) {
            v = "X";
        } else {
            v = "O";
        }
        for (int i = 0; i < 3; i++) {
            if (arr[i][0].equals(v) && arr[i][1].equals(v) && arr[i][2].equals(v)) {
                if (v == "X"){
                    ganador.setText("GANADOR JUGADOR");
                    jugador.setText("FIN DEL JUEGO");
                    clickable();
                    return true;
                }else {
                    ganador.setText("GANADOR CPU");
                    jugador.setText("FIN DEL JUEGO");
                    clickable();
                    return true;
                }
            } else if (arr[0][i].equals(v) && arr[1][i].equals(v) && arr[2][i].equals(v)) {
                if (v == "X"){
                    ganador.setText("GANADOR JUGADOR");
                    jugador.setText("FIN DEL JUEGO");
                    clickable();
                    return true;
                }else {
                    ganador.setText("GANADOR CPU");
                    jugador.setText("FIN DEL JUEGO");
                    clickable();
                    return true;
                }
            }
        }
        if (arr[0][0].equals(v) && arr[1][1].equals(v) && arr[2][2].equals(v)) {
            if (v == "X"){
                ganador.setText("GANADOR JUGADOR");
                jugador.setText("FIN DEL JUEGO");
                clickable();
                return true;
            }else {
                ganador.setText("GANADOR CPU");
                jugador.setText("FIN DEL JUEGO");
                clickable();
                return true;
            }
        } else if (arr[2][0].equals(v) && arr[1][1].equals(v) && arr[0][2].equals(v)) {
            if (v == "X"){
                ganador.setText("GANADOR JUGADOR");
                jugador.setText("FIN DEL JUEGO");
                clickable();
                return true;
            }else {
                ganador.setText("GANADOR CPU");
                jugador.setText("FIN DEL JUEGO");
                clickable();
                return true;
            }
        }
        if (c == 9){
            ganador.setText("EMPATE");
            jugador.setText("FIN DEL JUEGO");
            c = 0;
            return true;
        }
        return false;
    }
}
