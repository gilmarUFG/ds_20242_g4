import React from 'react';
import { View, Text, Button } from 'react-native';
import { useRouter } from 'expo-router';

const HomeScreen = () => {
  const router = useRouter();

  return (
    <View>
      <Text>Tela Inicial</Text>
      <Button
        title="Ver Calendário"
        onPress={() => router.push('/calendario')}
      />
    </View>
  );
};

export default HomeScreen;
