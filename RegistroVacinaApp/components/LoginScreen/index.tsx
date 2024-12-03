/*import React, { useState } from "react";
import { View, Text, TextInput, TouchableOpacity, StyleSheet } from "react-native";
import { useRouter } from "expo-router";
import AsyncStorage from "@react-native-async-storage/async-storage";
import api from "../../utils/api";

const LoginScreen = () => {
  const [cpf, setCpf] = useState("");
  const router = useRouter();

  const handleLogin = async () => {
    try {
      const response = await api.post("/login", { cpf });
      if (response.status === 200) {
        // Salvar o estado de login no AsyncStorage
        await AsyncStorage.setItem("isLoggedIn", "true");
        router.push("/home");
      } else {
        alert("Login falhou. Verifique o CPF.");
      }
    } catch (error) {
      alert("Erro ao realizar login. Verifique a conexão ou tente novamente.");
    }
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Validação de Login</Text>
      <Text style={styles.subtitle}>Você não está logado.</Text>
      <Text>Entre com o CPF para acessar suas informações de vacinação.</Text>
      <TextInput
        style={styles.input}
        placeholder="Digite seu CPF"
        keyboardType="numeric"
        value={cpf}
        onChangeText={setCpf}
      />
      <TouchableOpacity style={styles.button} onPress={handleLogin}>
        <Text style={styles.buttonText}>Entrar</Text>
      </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    padding: 20,
  },
  title: {
    fontSize: 24,
    fontWeight: "bold",
    marginBottom: 10,
  },
  subtitle: {
    fontSize: 16,
    marginBottom: 20,
  },
  input: {
    borderWidth: 1,
    borderColor: "#ccc",
    padding: 10,
    width: "80%",
    marginBottom: 20,
    borderRadius: 5,
  },
  button: {
    backgroundColor: "#0066cc",
    padding: 15,
    borderRadius: 5,
  },
  buttonText: {
    color: "#fff",
    fontSize: 16,
  },
});

export default LoginScreen;

*/