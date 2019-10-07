# Kappa Updated Ensemble for drifting data stream mining

Learning from data streams in the presence of concept drift is among the biggest challenges of contemporary machine learning. Algorithms designed for such scenarios must take into an account the potentially unbounded size of data, its constantly changing nature, and the requirement for real-time processing. Ensemble approaches for data stream mining have gained significant popularity, due to their high predictive capabilities and effective mechanisms for alleviating concept drift. In this paper, we propose a new ensemble method named Kappa Updated Ensemble (KUE). It is a combination of online and block-based ensemble approaches that uses Kappa statistic for dynamic weighting and selection of base classifiers. In order to achieve a higher diversity among base learners, each of them is trained using a different subset of features and updated with new instances with given probability following a Poisson distribution. Furthermore, we update the ensemble with new classifiers only when they contribute positively to the improvement of the quality of the ensemble. Finally, each base classifier in KUE is capable of abstaining itself for taking a part in voting, thus increasing the overall robustness of KUE. An extensive experimental study shows that KUE is capable of outperforming state-of-the-art ensembles on standard and imbalanced drifting data streams while having a low computational complexity. Moreover, we analyze the use of Kappa versus accuracy to drive the criterion to select and update the classifiers, the contribution of the abstaining mechanism, the contribution of the diversification of classifiers, and the contribution of the hybrid architecture to update the classifiers in an online manner.

# Manuscript

https://link.springer.com/article/10.1007/s10994-019-05840-z

# Citing Kappa Updated Ensemble

A. Cano and B. Krawczyk. Kappa Updated Ensemble for Drifting Data Stream Mining. Machine Learning, DOI: 10.1007/s10994-019-05840-z, 2019.
