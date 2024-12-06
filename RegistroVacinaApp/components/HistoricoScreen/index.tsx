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
        params: { pacienteId, nomeVacina, dataVacinacao },
      });
      setHistorico(response.data); // Supondo que o retorno seja um array
    } catch (err: any) {
      setError("Erro ao buscar histórico. Verifique os parâmetros e tente novamente.");
      console.error("Erro:", err);
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
      <TextInput
        placeholder="Nome da Vacina (opcional)"
        onChangeText={setNomeVacina}
        value={nomeVacina}
        style={styles.input}
      />
      <TextInput
        placeholder="Data de Vacinação (AAAA-MM-DD, opcional)"
        onChangeText={setDataVacinacao}
        value={dataVacinacao}
        style={styles.input}
      />
      <Button title="Buscar Histórico" onPress={buscarHistorico} />

      {isLoading && <Text>Carregando...</Text>}
      {!!error && <Text style={styles.errorText}>{error}</Text>}

      <ScrollView style={styles.historyList}>
        {historico.map((item, index) => (
          <View key={index} style={styles.historyItem}>
            <Text style={styles.vaccineName}>Vacina: {item.nomeVacina}</Text>
            <Text>Data da Vacinação: {item.dataVacinacao}</Text>
            <Text>Lote: {item.loteVacinacao}</Text>
            <Text>Ano de Vencimento: {item.anoVencimneto}</Text>
            <Text>Quantidade de Doses: {item.quantidadeDoses}</Text>
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
