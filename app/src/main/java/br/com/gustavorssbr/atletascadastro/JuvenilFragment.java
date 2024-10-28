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
import br.com.gustavorssbr.atletascadastro.model.AtletaJuvenil;

public class JuvenilFragment extends Fragment {
    private View view;

    EditText etNomeJ;
    EditText etDataJ;
    EditText etBairroJ;
    EditText etQtAnosJ;
    Button btnCadastrarJ;


    public JuvenilFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_juvenil, container, false);

        etNomeJ = view.findViewById(R.id.etNomeJ);
        etDataJ = view.findViewById(R.id.etDataJ);
        etBairroJ = view.findViewById(R.id.etBairroJ);
        etQtAnosJ = view.findViewById(R.id.etQtAnosJ);
        btnCadastrarJ = view.findViewById(R.id.btnCadastrarJ);

        btnCadastrarJ.setOnClickListener(op -> cadastrar());

        return view;
    }

    private void cadastrar() {
        AtletaJuvenil atletaJuvenil = new AtletaJuvenil(etNomeJ.getText().toString()
                , etDataJ.getText().toString()
                , etBairroJ.getText().toString()
                , Integer.parseInt(etQtAnosJ.getText().toString()));

        IOperacao<AtletaJuvenil> operacao = new OperacaoJuvenil();

        operacao.cadastrar(atletaJuvenil);

        StringBuffer buffer = new StringBuffer();

        List<AtletaJuvenil> lista = operacao.listar();

        lista.forEach(e -> buffer.append(e).append("\n"));

        Toast.makeText(view.getContext(), buffer.toString(), Toast.LENGTH_LONG).show();

        limparCampos();
    }

    private void limparCampos() {
        etNomeJ.setText("");
        etDataJ.setText("");
        etBairroJ.setText("");
        etQtAnosJ.setText("");
    }
}