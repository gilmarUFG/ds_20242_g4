import React, { useState } from 'react';
import { View, Text, TextInput, Button } from 'react-native';
import api from '../../utils/api';

const CalendarioScreen = () => {
  const [idade, setIdade] = useState('');
  const [calendario, setCalendario] = useState<any>(null);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);

  const buscarCalendario = async () => {
    setIsLoading(true);
    setError(null);
    try {
      const response = await api.get('/calendario/vacinacao', {
        params: { idade },
      });
      setCalendario(response.data);
    } catch (err) {
      setError(err.message);
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <View>
      <Text>Calendário de Vacinação</Text>
      <TextInput
        placeholder="Digite sua idade"
        keyboardType="numeric"
        onChangeText={setIdade}
        value={idade}
      />
      <Button title="Buscar Calendário" onPress={buscarCalendario} />

      {isLoading && <Text>Carregando...</Text>}
      {error && <Text style={{ color: 'red' }}>Erro: {error}</Text>}
      {calendario && (
        <View>
          {calendario.map((item: any) => (
            <View key={item.calendarioId}>
              <Text>Categoria: {item.categoria}</Text>
              <Text>Doses: {item.doses}</Text>
              <Text>
                Faixa Etária: {item.faixaEtariaObjeto.mesesinicial} -{' '}
                {item.faixaEtariaObjeto.mesesfinal}
              </Text>
              <Text>Vacinas: {item.vacinas}</Text>
              <Text>-----------------</Text>
            </View>
          ))}
        </View>
      )}
    </View>
  );
};

export default CalendarioScreen;
