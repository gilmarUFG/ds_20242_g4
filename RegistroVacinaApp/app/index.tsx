import { useState, useEffect } from 'react';
import { View, ActivityIndicator, Text, TouchableOpacity, Image, StyleSheet } from 'react-native';
import { useRouter } from 'expo-router';
import AsyncStorage from '@react-native-async-storage/async-storage';
import React from 'react';


const HomeScreen = () => {
    const router = useRouter();
    return (
        <View style={styles.container}>
            {/* Header */}
            <View style={styles.header}>
                <Image
                    source={require('../assets/images/ic_vaccine.png')}
                    style={styles.headerImage}
                />
                <Text style={styles.headerText}>Vacinação</Text>
            </View>
            {/* Botões lado a lado */}
            <View style={styles.buttonRow}>
                {/* Calendário Button */}
                <View style={styles.buttonContainer}>
                    <TouchableOpacity style={styles.button} onPress={() => router.push('/calendario')}>
                        <Image
                            source={require('../assets/images/calendario.png')}
                            style={styles.image}
                        />
                    </TouchableOpacity>
                    <Text style={styles.buttonText}>Calendário</Text>
                </View>
                {/* Histórico Button */}
                <View style={styles.buttonContainer}>
                    <TouchableOpacity style={styles.button} onPress={() => router.push('/historico')}>
                        <Image
                            source={require('../assets/images/historico.png')}
                            style={styles.image}
                        />
                    </TouchableOpacity>
                    <Text style={styles.buttonText}>Histórico</Text>
                </View>
            </View>
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#FFFFFF',
        paddingTop: 20,
    },
    header: {
        backgroundColor: '#0066cc',
        paddingVertical: 20,
        paddingHorizontal: 10,
        flexDirection: 'row',
        alignItems: 'center',
        marginBottom: 20,
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
    buttonRow: {
        flexDirection: 'row',
        justifyContent: 'space-around',
        paddingHorizontal: 20,
        marginTop: 20,
    },
    buttonContainer: {
        alignItems: 'center',
    },
    button: {
        alignItems: 'center',
        backgroundColor: '#E2EAFF',
        padding: 10,
        borderRadius: 8,
        width: 100,
        height: 100,
    },
    image: {
        width: 50,
        height: 50,
    },
    buttonText: {
        fontSize: 16,
        color: '#000',
        marginTop: 10,
    },
});

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