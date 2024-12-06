import { useState, useEffect } from 'react';
import { View, ActivityIndicator, Text } from 'react-native';
import { useRouter } from 'expo-router';
import AsyncStorage from '@react-native-async-storage/async-storage';
import React from 'react';
import HomeScreen from "../components/HomeScreen";

export default function App() {
  const [isLoading, setIsLoading] = useState(true);
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const router = useRouter();

  useEffect(() => {
    const checkLoginStatus = async () => {
      try {
        const pacienteId = await AsyncStorage.getItem('pacienteId');
        setIsLoggedIn(!!pacienteId);
        if (!isLoggedIn) {
          router.replace('/login'); //Redireciona para o login se não estiver logado
        }
      } catch (error) {
        console.error("Erro ao verificar login:", error);
      } finally {
        setIsLoading(false);
      }
    };

    checkLoginStatus();
  }, [isLoggedIn, router]);


  if (isLoading) {
    return (
      <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
        <ActivityIndicator size="large" />
      </View>
    );
  }

  if (!isLoggedIn) {
    return <Text>Carregando...</Text>; // Exibe uma mensagem enquanto verifica o login.
  }


  return (
      <HomeScreen/>
  );
}