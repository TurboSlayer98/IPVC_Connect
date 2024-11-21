data class EscolaResponse(
    val id: Int,
    val nome: String,
    val descricao: String,
    val logoUrl: String
)

data class CursoResponse(
    val id: Int,
    val nome: String,
    val descricao: String,
    val escola: String,
    val duracaoAnos: Int
)

data class EmpresaResponse(
    val id: Int,
    val nome: String,
    val descricao: String,
    val localizacao: String,
    val curso: String,
    val morada: String,
    val telefone: String,
    val email: String,
    val vagasDisponiveis: Int,
    val vagasOcupadas: Int,
    val latitude: Double,
    val longitude: Double,
    val dataCriacao: String,
    val dataAtualizacao: String
)

data class ComentarioResponse(
    val id: Int,
    val texto: String,
    val data: String,
    val empresaId: Int
)

data class ComentarioRequest(
    val texto: String
) 