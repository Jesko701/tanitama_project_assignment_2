import time
import os
import cv2
import numpy as np
import pandas as pd
import tensorflow as tf
from flask import Flask, request, jsonify, render_template
from sklearn.preprocessing import MinMaxScaler

app = Flask(__name__)
app.config['MAX_CONTENT_LENGTH'] = 10 * 1024 * 1024


@app.route("/")
def index():
    return render_template('static/index.html', )

@app.route('/predictberas', methods=['GET'])
def predictBeras():
    model = tf.keras.models.load_model('./static/1.h5')
    #Load Data
    df = pd.read_csv('./data/DataBaru_HargaPangan.csv')

    #Filter Data as 'Beras' only
    data_filter = df.filter(['Beras'])
    data = data_filter.values
    data = np.array(data)

    #Normalize
    scaler = MinMaxScaler(feature_range=(0, 1))
    scaled_value = scaler.fit_transform(data)

    #Reshaping process
    seq_legth = 3
    result_data = []
    for i in range(seq_legth, len(scaled_value)):
        result_data.append(scaled_value[i - seq_legth:i, 0])

    result_data = np.array(result_data)
    result_data = np.reshape(result_data, (result_data.shape[0], result_data.shape[1], 1))

    #Make predictions
    predict = model.predict(result_data)
    unscaled_predict = scaler.inverse_transform(predict)

    #Return as JSON
    response = {'Beras': unscaled_predict.tolist()}
    return jsonify(response)

@app.route('/predictbawangmerah', methods=['GET'])
def predictBawangMerah():
    model = tf.keras.models.load_model('./static/2.h5')
    #Load Data
    df = pd.read_csv('./data/DataBaru_HargaPangan.csv')

    #Filter Data as 'Beras' only
    data_filter = df.filter(['Bawang Merah'])
    data = data_filter.values
    data = np.array(data)

    #Normalize
    scaler = MinMaxScaler(feature_range=(0, 1))
    scaled_value = scaler.fit_transform(data)

    #Reshaping process
    seq_legth = 3
    result_data = []
    for i in range(seq_legth, len(scaled_value)):
        result_data.append(scaled_value[i - seq_legth:i, 0])

    result_data = np.array(result_data)
    result_data = np.reshape(result_data, (result_data.shape[0], result_data.shape[1], 1))

    #Make predictions
    predict = model.predict(result_data)
    unscaled_predict = scaler.inverse_transform(predict)

    #Return as JSON
    response = {'Bawang Merah': unscaled_predict.tolist()}
    return jsonify(response)

@app.route('/predictbawangputih', methods=['GET'])
def predictBawangPutih():
    model = tf.keras.models.load_model('./static/3.h5')
    #Load Data
    df = pd.read_csv('./data/DataBaru_HargaPangan.csv')

    #Filter Data as 'Beras' only
    data_filter = df.filter(['Bawang Putih'])
    data = data_filter.values
    data = np.array(data)

    #Normalize
    scaler = MinMaxScaler(feature_range=(0, 1))
    scaled_value = scaler.fit_transform(data)

    #Reshaping process
    seq_legth = 3
    result_data = []
    for i in range(seq_legth, len(scaled_value)):
        result_data.append(scaled_value[i - seq_legth:i, 0])

    result_data = np.array(result_data)
    result_data = np.reshape(result_data, (result_data.shape[0], result_data.shape[1], 1))

    #Make predictions
    predict = model.predict(result_data)
    unscaled_predict = scaler.inverse_transform(predict)

    #Return as JSON
    response = {'Bawang Putih': unscaled_predict.tolist()}
    return jsonify(response)

@app.route('/predictcabaimerah', methods=['GET'])
def predictCabaiMerah():
    model = tf.keras.models.load_model('./static/4.h5')
    #Load Data
    df = pd.read_csv('./data/DataBaru_HargaPangan.csv')

    #Filter Data as 'Beras' only
    data_filter = df.filter(['Cabai Merah'])
    data = data_filter.values
    data = np.array(data)

    #Normalize
    scaler = MinMaxScaler(feature_range=(0, 1))
    scaled_value = scaler.fit_transform(data)

    #Reshaping process
    seq_legth = 3
    result_data = []
    for i in range(seq_legth, len(scaled_value)):
        result_data.append(scaled_value[i - seq_legth:i, 0])

    result_data = np.array(result_data)
    result_data = np.reshape(result_data, (result_data.shape[0], result_data.shape[1], 1))

    #Make predictions
    predict = model.predict(result_data)
    unscaled_predict = scaler.inverse_transform(predict)

    #Return as JSON
    response = {'Cabai Merah': unscaled_predict.tolist()}
    return jsonify(response)

if __name__ == "__main__": 
        app.run(debug=True, host='0.0.0.0', port=2000)