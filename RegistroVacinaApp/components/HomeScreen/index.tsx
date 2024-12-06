import { View, Text, TouchableOpacity, Image, StyleSheet } from 'react-native';
import { useRouter } from 'expo-router';
import React from 'react';

const HomeScreen = () => {
    const router = useRouter();
    return (
        <View style={styles.container}>
            {/* Header */}
            <View style={styles.header}>
                <Image
                    source={require('../../assets/images/ic_vaccine.png')}
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
                            source={require('../../assets/images/calendario.png')}
                            style={styles.image}
                        />
                    </TouchableOpacity>
                    <Text style={styles.buttonText}>Calendário</Text>
                </View>
                {/* Histórico Button */}
                <View style={styles.buttonContainer}>
                    <TouchableOpacity style={styles.button} onPress={() => router.push('/historico')}>
                        <Image
                            source={require('../../assets/images/historico.png')}
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
      backgroundColor: "#FFFFFF",
      paddingTop: 20,
    },
    header: {
      backgroundColor: "#0066cc",
      paddingVertical: 20,
      paddingHorizontal: 10,
      flexDirection: "row",
      alignItems: "center",
      marginBottom: 20,
    },
    headerImage: {
      width: 40,
      height: 40,
      marginRight: 10,
    },
    headerText: {
      fontSize: 24,
      fontWeight: "bold",
      color: "#fff",
    },
    buttonRow: {
      flexDirection: "row",
      justifyContent: "space-around",
      paddingHorizontal: 20,
      marginTop: 20,
    },
    buttonContainer: {
      alignItems: "center",
    },
    button: {
      alignItems: "center",
      backgroundColor: "#E2EAFF",
      padding: 10,
      borderRadius: 8,
      width: 50,
      height: 50,
    },
    image: {
      width: 30,
      height: 30,
    },
    buttonText: {
      fontSize: 14,
      color: "#000",
      marginTop: 10,
    },
  });
  
  export default HomeScreen;