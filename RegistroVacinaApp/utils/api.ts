import axios from 'axios';

// Cria uma instância do Axios com a URL base da API
const api = axios.create({
  baseURL: 'http://localhost:8080/api',  // URL base da API
  timeout: 10000,  // Tempo limite de 10 segundos
  headers: {
    'Content-Type': 'application/json',  // Cabeçalho padrão
  },
});