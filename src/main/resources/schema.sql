CREATE TABLE IF NOT EXISTS categoria (
    id TEXT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    ordem_exibicao INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS produto (
    id TEXT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10, 2) NOT NULL,
    imagem_url VARCHAR(255),
    ativo INTEGER NOT NULL DEFAULT 1 CHECK (ativo IN (0, 1)),
    categoria_id TEXT,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);

CREATE TABLE IF NOT EXISTS adicional (
    id TEXT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    ativo INTEGER NOT NULL DEFAULT 1 CHECK (ativo IN (0, 1)),
    produto_id TEXT,
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);

CREATE TABLE IF NOT EXISTS pedido (
    id TEXT PRIMARY KEY,
    data_pedido DATETIME NOT NULL,
    nome_cliente VARCHAR(255) NOT NULL,
    telefone_cliente VARCHAR(255) NOT NULL,
    endereco_cliente VARCHAR(255) NOT NULL,
    valor_total DECIMAL(10, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS item_pedido (
    id TEXT PRIMARY KEY,
    pedido_id TEXT,
    produto_id TEXT,
    quantidade INTEGER NOT NULL,
    observacao TEXT,
    preco_unitario DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES pedido(id),
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);

CREATE TABLE IF NOT EXISTS admin_usuario (
    id TEXT PRIMARY KEY,
    username VARCHAR(120) NOT NULL UNIQUE,
    senha_hash VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL DEFAULT 'ADMIN',
    ativo INTEGER NOT NULL DEFAULT 1 CHECK (ativo IN (0, 1)),
    created_at DATETIME NOT NULL
);