package com.lp4.login.view

import androidx.activity.viewModels
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lp4.character.view.NewCharacterActivity
import com.lp4.home.view.HomeActivity
import com.lp4.databinding.ActivityLoginBinding
import com.lp4.login.presentation.LoginViewModel
import com.lp4.login.presentation.ViewState

open class LoginActivity : AppCompatActivity() {

   private val viewModel: LoginViewModel by viewModels()

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnLogin.setOnClickListener {
            irParaAHome()
        }

        binding.tvNovo.setOnClickListener(){
            irParaCadastro()
        }

        configLoginButton()
        viewModel.viewState.observe(this) { state ->
            when (state) {
                is
                ViewState.ShowError -> mostrarErro()
                ViewState.ShowErrorEmail -> {}
                ViewState.ShowErrorPassword -> {}
                ViewState.ShowSuccess -> irParaAHome()
            }
        }
    }

    private fun configLoginButton() {
        binding.btnLogin.setOnClickListener {
            viewModel.validarInputs(
                email = binding.etNome.text.toString(),
                senha = binding.etSenha.text.toString()
            )
        }
    }

    private fun mostrarErro() {
        binding.etNome.setError("Email Inválido")
        binding.etSenha.setError("Senha Inválida")
    }

    private fun irParaAHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun irParaCadastro() {
        val intent = Intent(this, NewCharacterActivity::class.java)
        startActivity(intent)
    }

}