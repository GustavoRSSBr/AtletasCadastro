package br.com.gustavorssbr.atletascadastro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import br.com.gustavorssbr.atletascadastro.controller.IOperacao;
import br.com.gustavorssbr.atletascadastro.controller.OperacaoJuvenil;
import br.com.gustavorssbr.atletascadastro.controller.OperacaoSenior;
import br.com.gustavorssbr.atletascadastro.model.AtletaJuvenil;
import br.com.gustavorssbr.atletascadastro.model.AtletaSenior;


public class SeniorFragment extends Fragment {
    private View view;

    EditText etNomeS;
    EditText etDataS;
    EditText etBairroS;
    CheckBox cbCoracaoS;
    Button btnCadastrarS;


    public SeniorFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_senior, container, false);

        etNomeS = view.findViewById(R.id.etNomeS);
        etDataS = view.findViewById(R.id.etDataS);
        etBairroS = view.findViewById(R.id.etBairroS);
        cbCoracaoS = view.findViewById(R.id.cbCoracaoS);
        btnCadastrarS = view.findViewById(R.id.btnCadastrarS);


        btnCadastrarS.setOnClickListener(op -> cadastrar());
        return view;
    }

    private void cadastrar() {

        AtletaSenior atletaSenior = new AtletaSenior(etNomeS.getText().toString()
                , etDataS.getText().toString()
                , etBairroS.getText().toString()
                , cbCoracaoS.isChecked());

        IOperacao<AtletaSenior> operacao = new OperacaoSenior();

        operacao.cadastrar(atletaSenior);

        StringBuffer buffer = new StringBuffer();

        List<AtletaSenior> lista = operacao.listar();

        lista.forEach(e -> buffer.append(e).append("\n"));

        Toast.makeText(view.getContext(), buffer.toString(), Toast.LENGTH_LONG).show();

        limparCampos();

    }

    private void limparCampos() {
        etNomeS.setText("");
        etDataS.setText("");
        etBairroS.setText("");
        cbCoracaoS.setChecked(false);
    }
}