package br.com.gustavorssbr.atletascadastro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import br.com.gustavorssbr.atletascadastro.controller.IOperacao;
import br.com.gustavorssbr.atletascadastro.controller.OperacaoJuvenil;
import br.com.gustavorssbr.atletascadastro.controller.OperacaoOutro;
import br.com.gustavorssbr.atletascadastro.model.AtletaJuvenil;
import br.com.gustavorssbr.atletascadastro.model.AtletaOutro;


public class OutroFragment extends Fragment {

    private View view;

    EditText etNomeO;
    EditText etDataO;
    EditText etBairroO;
    EditText etRecordO;
    EditText etAcademiaO;

    Button btnCadastrarO;


    public OutroFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_outro, container, false);

        etNomeO = view.findViewById(R.id.etNomeO);
        etDataO = view.findViewById(R.id.etDataO);
        etBairroO = view.findViewById(R.id.etBairroO);
        etRecordO = view.findViewById(R.id.etRecordO);
        etAcademiaO = view.findViewById(R.id.etAcademiaO);

        btnCadastrarO = view.findViewById(R.id.btnCadastrarO);

        btnCadastrarO.setOnClickListener(op -> cadastrar());

        return view;

    }

    private void cadastrar() {

        AtletaOutro atletaOutro = new AtletaOutro(etNomeO.getText().toString()
                , etDataO.getText().toString()
                , etBairroO.getText().toString()
                , etAcademiaO.getText().toString()
                , Integer.parseInt(etRecordO.getText().toString())
        );

        IOperacao<AtletaOutro> operacao = new OperacaoOutro();

        operacao.cadastrar(atletaOutro);

        StringBuffer buffer = new StringBuffer();

        List<AtletaOutro> lista = operacao.listar();

        lista.forEach(e -> buffer.append(e).append("\n"));

        Toast.makeText(view.getContext(), buffer.toString(), Toast.LENGTH_LONG).show();
        limpaCampos();

    }

    private void limpaCampos() {
        etNomeO.setText("");
        etDataO.setText("");
        etBairroO.setText("");
        etAcademiaO.setText("");
        etRecordO.setText("");
    }
}