import React, { useState } from "react";
import {
  View,
  Text,
  TextInput,
  Button,
  ScrollView,
  StyleSheet,
  Image,
} from "react-native";
import api from "../../utils/api";

const HistoricoScreen = () => {
  const [historico, setHistorico] = useState([]);
  const [pacienteId, setPacienteId] = useState("");
  const [nomeVacina, setNomeVacina] = useState("");
  const [dataVacinacao, setDataVacinacao] = useState("");
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const buscarHistorico = async () => {
    setIsLoading(true);
    setError(null);
    try {
      const response = await api.get("/historico", {
        params: { pacienteId },
      });
      setHistorico(response.data);
    } catch (err: any) {
      setError(err.message);
    } finally {
      setIsLoading(false);
    }
  };

  const buscarHistoricoComFiltros = async () => {
    setIsLoading(true);
    setError(null);
    try {
      const response = await api.get("/historico", {
        params: { nomeVacina, dataVacinacao },
      });
      setHistorico(response.data);
    } catch (err: any) {
      setError(err.message);
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <View style={styles.container}>
      <View style={styles.header}>
        <Image
          source={require("../../assets/images/historico_icon.png")}
          style={styles.headerImage}
        />
        <Text style={styles.headerText}>Histórico de Vacinação</Text>
      </View>

      <TextInput
        placeholder="Digite o ID do paciente"
        onChangeText={setPacienteId}
        value={pacienteId}
        style={styles.input}
      />
      <Button title="Buscar Histórico" onPress={buscarHistorico} />

      <Text style={styles.filterText}>Filtrar por Nome e Data da Vacina</Text>
      <TextInput
        placeholder="Nome da Vacina"
        onChangeText={setNomeVacina}
        value={nomeVacina}
        style={styles.input}
      />
      <TextInput
        placeholder="Data de Vacinação (AAAA-MM-DD)"
        onChangeText={setDataVacinacao}
        value={dataVacinacao}
        style={styles.input}
      />
      <Button title="Buscar com Filtros" onPress={buscarHistoricoComFiltros} />

      {isLoading && <Text>Carregando...</Text>}
      {!!error && <Text style={styles.errorText}>Erro: {error}</Text>}

      <ScrollView style={styles.historyList}>
        {historico.map((item: any) => (
          <View key={item.id} style={styles.historyItem}>
            <Text style={styles.vaccineName}>{item.vacina.nome}</Text>
            <Text>Dose: {item.dose}</Text>
            <Text>Data: {item.data}</Text>
          </View>
        ))}
      </ScrollView>
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
  input: {
    borderWidth: 1,
    borderColor: "#000",
    padding: 10,
    marginVertical: 10,
    borderRadius: 8,
  },
  filterText: {
    fontSize: 16,
    marginVertical: 10,
    fontWeight: "bold",
  },
  historyList: {
    marginTop: 20,
  },
  historyItem: {
    padding: 15,
    borderRadius: 8,
    backgroundColor: "#f0f0f0",
    marginBottom: 10,
  },
  vaccineName: {
    fontSize: 16,
    fontWeight: "bold",
  },
  errorText: {
    color: "red",
    marginTop: 10,
  },
});

export default HistoricoScreen;
