import React, { useState } from 'react';
import { View, Text, TextInput, TouchableOpacity, StyleSheet, Image, ActivityIndicator } from 'react-native';
import { useRouter } from 'expo-router';
import AsyncStorage from '@react-native-async-storage/async-storage';
import api from '../../utils/api';


const LoginScreen = () => {
  const router = useRouter();
  const [cpf, setCpf] = useState('');
  const [error, setError] = useState('');
  const [isLoading, setIsLoading] = useState(false);

  const handleLogin = async () => {
    setIsLoading(true);
    setError('');
    try {
      const response = await api.post('/login', { cpf });
      if (response.status === 200) {
        await AsyncStorage.setItem('pacienteId', response.data.pacienteId.toString());
        router.push('/home');
      } else {
        setError('CPF inválido ou usuário não encontrado.');
      }
    } catch (error) {
      setError('Erro ao efetuar login. Por favor, tente novamente.');
      console.error("Erro de login:", error);
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <View style={styles.container}>
      <View style={styles.header}>
        <Image
          //source={require('../assets/images/ic_vaccine.png')}
          //style={styles.headerImage}
        />
        <Text style={styles.headerText}>Login</Text>
      </View>

      <TextInput
        style={styles.input}
        placeholder="CPF"
        keyboardType="number-pad"
        value={cpf}
        onChangeText={setCpf}
      />

      {!!error && <Text style={styles.errorText}>{error}</Text>}

      <TouchableOpacity style={styles.button} onPress={handleLogin} disabled={isLoading}>
        {isLoading ? (
          <ActivityIndicator size="small" color="#fff" />
        ) : (
          <Text style={styles.buttonText}>Entrar</Text>
        )}
      </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#FFFFFF',
    alignItems: 'center',
    justifyContent: 'center',
    paddingTop: 20,
  },
  header: {
    backgroundColor: '#0066cc',
    paddingVertical: 20,
    paddingHorizontal: 10,
    flexDirection: 'row',
    alignItems: 'center',
    marginBottom: 20,
    width: '100%',
  },
  headerImage: {
    width: 40,
    height: 40,
    marginRight: 10,
  },
  headerText: {
    fontSize: 24,
    fontWeight: 'bold',
    color: '#fff',
  },
  input: {
    height: 40,
    borderColor: 'gray',
    borderWidth: 1,
    marginBottom: 10,
    paddingHorizontal: 10,
    width: '80%',
  },
  button: {
    backgroundColor: '#0066cc',
    padding: 10,
    borderRadius: 8,
    width: '80%',
    alignItems: 'center',
  },
  buttonText: {
    color: '#fff',
    fontSize: 16,
  },
  errorText: {
    color: 'red',
    marginBottom: 10,
  },
});

export default LoginScreen;