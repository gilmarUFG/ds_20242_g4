import React from 'react';
import { View, Text, TouchableOpacity, Image, StyleSheet, ScrollView } from 'react-native';
import { useRouter } from 'expo-router';

const NotificacaoScreen = () => {

    // Aqui você pode simular algumas notificações para exibir
    const notifications = [
        { id: 1, title: 'Vacina Agendada!', message: 'Sua vacina foi agendada para o dia 15/08/2024.' },
        { id: 2, title: 'Lembrete de Vacinação', message: 'Não se esqueça de levar a carteirinha de vacinação!' },
        { id: 3, title: 'Nova Vacina Disponível', message: 'Uma nova vacina está disponível para você! Consulte o calendário.' },
        { id: 4, title: 'Vacina Agendada!', message: 'Sua vacina foi agendada para o dia 15/08/2024.' },
        { id: 5, title: 'Lembrete de Vacinação', message: 'Não se esqueça de levar a carteirinha de vacinação!' },
        { id: 6, title: 'Nova Vacina Disponível', message: 'Uma nova vacina está disponível para você! Consulte o calendário.' },
        { id: 7, title: 'Vacina Agendada!', message: 'Sua vacina foi agendada para o dia 15/08/2024.' },
        { id: 8, title: 'Lembrete de Vacinação', message: 'Não se esqueça de levar a carteirinha de vacinação!' },
        { id: 9, title: 'Nova Vacina Disponível', message: 'Uma nova vacina está disponível para você! Consulte o calendário.' },
      ];

    return (
        <View style={styles.container}>
            {/* Header */}
            <View style={styles.header}>
                <Text style={styles.headerText}>Notificações</Text>
            </View>

            {/* Lista de Notificações */}
            <ScrollView style={styles.notificationList}>
                {notifications.map(notification => (
                    <View key={notification.id} style={styles.notificationItem}>
                        <Text style={styles.notificationTitle}>{notification.title}</Text>
                        <Text style={styles.notificationMessage}>{notification.message}</Text>
                    </View>
                ))}
            </ScrollView>
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#FFFFFF',
    },
    header: {
        backgroundColor: '#0066cc',
        paddingVertical: 20,
        paddingHorizontal: 10,
        flexDirection: 'row',
        alignItems: 'center',
        marginBottom: 10,
        justifyContent: 'center',
    },
    backButton: {
        marginRight: 10,
    },
    headerImage: {
        width: 40,
        height: 40,
    },
    headerText: {
        fontSize: 24,
        fontWeight: 'bold',
        color: '#fff',
    },
    notificationList: {
        flex: 1,
        paddingHorizontal: 10,
    },
    notificationItem: {
        backgroundColor: '#f0f0f0',
        padding: 15,
        marginBottom: 10,
        borderRadius: 8,
    },
    notificationTitle: {
        fontSize: 18,
        fontWeight: 'bold',
        marginBottom: 5,
    },
    notificationMessage: {
        fontSize: 16,
    },
});

export default NotificacaoScreen;