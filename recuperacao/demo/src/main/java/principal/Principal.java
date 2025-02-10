package principal;

import com.basicas.Empresa;
import com.basicas.Endereco;
import com.basicas.Funcionario;
import com.dao.EmpresaDao;
import com.dao.EnderecoDao;
import com.dao.FuncionarioDao;

public class Principal {
    public static void main(String[] args) {
        EmpresaDao empresaDao = new EmpresaDao();
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        EnderecoDao enderecoDao = new EnderecoDao();

        
        Empresa empresa = new Empresa("Hard tech", "12.345.678/0001-99");
        empresaDao.adicionarEmpresa(empresa);
        
        Endereco endereco = new Endereco("40000-000", "Av. Brasil", "123", "Centro", "Salvador");
        enderecoDao.adicionarEndereco(endereco);

        Funcionario funcionario = new Funcionario("Josue Silva", "2023001", "123.333.789-00", "1234567", endereco, empresa);
        funcionarioDao.adicionarFuncionario(funcionario);

        System.out.println(funcionarioDao.listarFuncionarios());
    }
}

