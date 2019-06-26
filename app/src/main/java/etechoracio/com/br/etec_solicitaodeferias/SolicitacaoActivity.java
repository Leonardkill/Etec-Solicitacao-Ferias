package etechoracio.com.br.etec_solicitaodeferias;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.Calendar;

import etechoracio.com.br.etec_solicitaodeferias.Utils.DateTimeUtils;

public class SolicitacaoActivity extends AppCompatActivity {

    private Spinner spnDias;
    private Button btnSelecionar;
    private Button btnDatafim;
    private RadioGroup radioOpcao;
    private RadioButton radioSim;
    private RadioButton radioNao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitacao);
        spnDias = findViewById(R.id.spnDias);
        btnSelecionar = findViewById(R.id.btnSelecionar);
        btnDatafim = findViewById(R.id.btnDatafim);
        radioOpcao = findViewById(R.id.radioOpcao);
        radioSim = findViewById(R.id.radioSim);
        radioNao = findViewById(R.id.radioNao);
        spnDias.setAdapter(spinnerSim());
    }



    private DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {
            String.valueOf(dia);
            String.valueOf(mes + 1);
            String.valueOf(ano);
        }
    };

    public void OnRadioClick (View a){
        if(a.getId() == R.id.radioSim){
            spnDias.setAdapter(spinnerSim());
        }
        else {
            spnDias.setAdapter(spinnerNao());
        }
    }

    private DatePickerDialog.OnDateSetListener dataSelecionar = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {

            btnSelecionar.setText(DateTimeUtils.formatDate(dia, mes, ano));
        }
    };

    protected Dialog onCreateDialog(int id) {
        Calendar cal = Calendar.getInstance();
        int ano = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);

        switch (id) {
            case R.id.btnSelecionar:
                return new DatePickerDialog(this, dataSelecionar, ano, mes, dia);
        }
        return null;
    }

    public void onSelecionarData (View view){
        showDialog(view.getId());
    }

    private ArrayAdapter spinnerSim(){
        return new ArrayAdapter<Integer>(this,
                R.layout.support_simple_spinner_dropdown_item,
                Arrays.asList(20,30));
    }

    private ArrayAdapter spinnerNao(){
        return new ArrayAdapter<Integer>(this,
                R.layout.support_simple_spinner_dropdown_item,
                Arrays.asList(10,15,20,30));
    }




}
